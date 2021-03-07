package com.nc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nc.common.Category;
import com.nc.common.ProductCategoryRequest;
import com.nc.common.ProductCategoryResponse;
import com.nc.model.Product;
import com.nc.repositoy.ProductRepository;

@Service
@RefreshScope
public class ProductService implements IProductService {
	private final ProductRepository productRepository;
	@Lazy
	private final RestTemplate restTemplate;
	@Value("${microservice.category-service.endpoint.uri}")
	private String CATEGORY_ENDPOINT_ID;

	public ProductService(ProductRepository productRepository, RestTemplate restTemplate) {
		this.productRepository = productRepository;
		this.restTemplate = restTemplate;
	}

	@Override
	public ProductCategoryResponse save(ProductCategoryRequest productCategoryRequest) {
		Product product = productCategoryRequest.getProduct();
		Category categoryResponse = restTemplate.getForObject(
				CATEGORY_ENDPOINT_ID + "/" + productCategoryRequest.getCategory().getId(), Category.class);

		if (categoryResponse == null) {
			return new ProductCategoryResponse(null, null, "ERROR: Category is not Found");
		}
		product.setCategoryId(categoryResponse.getId());
		Product productResponse = productRepository.save(product);

		if (productResponse == null) {
			return new ProductCategoryResponse(productResponse, categoryResponse, "ERROR: Request is Not Successful");
		}
		return new ProductCategoryResponse(productResponse, categoryResponse, "Request is Successful");
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
