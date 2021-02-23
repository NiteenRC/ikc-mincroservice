package com.nc.service;

import com.nc.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Optional<Category> findByCategoryID(Long categoryID);

    Category saveCategory(Category category);

    void deleteCategory(Category categoryID);

    Category findByCategoryName(String categoryName);

    List<Category> fetchAllCategories();
}
