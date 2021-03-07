package com.nc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nc.model.Category;
import com.nc.repositoy.CategoryRepo;

@Service
public class CategoryService implements ICategoryService {
	private CategoryRepo categoryRepo;

	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
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
		return categoryRepo.findAll();
	}
}
