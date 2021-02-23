package com.nc.common;

import com.nc.model.Product;

public class ProductCategoryResponse {
    private Product product;
    private Category category;
    private String message;

    public ProductCategoryResponse(Product product, Category category, String message) {
        this.product = product;
        this.category = category;
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
