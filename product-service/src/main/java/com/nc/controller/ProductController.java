package com.nc.controller;

import com.nc.common.ProductCategoryRequest;
import com.nc.common.ProductCategoryResponse;
import com.nc.model.Product;
import com.nc.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    public ResponseEntity<ProductCategoryResponse> save(@RequestBody ProductCategoryRequest productCategoryRequest) {
        ProductCategoryResponse productCategoryResponse = iProductService.save(productCategoryRequest);
        LOG.info("product {}", productCategoryResponse);
        return ResponseEntity.ok(productCategoryResponse);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = iProductService.findAll();
        LOG.info("products {}", products);
        return ResponseEntity.ok(products);
    }
}
