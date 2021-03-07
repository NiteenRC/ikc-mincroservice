package com.nc.service;

import com.nc.model.Category;
import com.nc.model.Product;
import com.nc.repositoy.CategoryRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    private CategoryRepo categoryRepo;
    private final RestTemplate restTemplate;

    public CategoryService(CategoryRepo categoryRepo, RestTemplate restTemplate) {
        this.categoryRepo = categoryRepo;
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<Category> findByCategoryID(Long categoryID) {
        return categoryRepo.findById(categoryID);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void deleteCategory(Category categoryID) {

    }

    @Override
    public Category findByCategoryName(String categoryName) {
        return null;
    }

    @Override
    public List<Category> fetchAllCategories() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        //restTemplate.exchange("http://PRODUCT-SERVICE/product", HttpMethod.GET,entity, List.class);


        //restTemplate.getForObject("http://PRODUCT-SERVICE/product", List.class);
        return categoryRepo.findAll();
    }
}
