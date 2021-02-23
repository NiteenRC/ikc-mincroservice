package com.nc.service;

import com.nc.common.ProductCategoryRequest;
import com.nc.common.ProductCategoryResponse;
import com.nc.model.Product;

import java.util.List;

public interface IProductService {
    ProductCategoryResponse save(ProductCategoryRequest productCategoryRequest);

    List<Product> findAll();
}
