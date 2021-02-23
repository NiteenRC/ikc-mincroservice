package com.nc.controller;

import com.nc.model.Category;
import com.nc.service.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final ICategoryService iCategoryService;

    public CategoryController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        if (iCategoryService.findByCategoryName(category.getCategoryName()) != null) {
            return ResponseEntity.ok("Category name already exist!!");
        }
        return ResponseEntity.ok(iCategoryService.saveCategory(category));
    }

    @PutMapping
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        LOG.info("category " + category.getCategoryName());
        return new ResponseEntity<>(iCategoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{categoryID}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryID) {
        Optional<Category> category = iCategoryService.findByCategoryID(categoryID);
        if (category == null) {
            return ResponseEntity.noContent().build();
        }
        iCategoryService.deleteCategory(category.get());
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategoryList() {
        return new ResponseEntity<>(iCategoryService.fetchAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{categoryID}")
    public ResponseEntity<Optional<Category>> findCategoryByID(@PathVariable Long categoryID) {
        Optional<Category> category = iCategoryService.findByCategoryID(categoryID);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/filter/categoryName")
    public ResponseEntity<?> addCategory(@PathVariable String categoryName) {
        Category category = iCategoryService.findByCategoryName(categoryName);
        if (category == null) {
            return ResponseEntity.ok("Category name not exist!!");
        }
        return ResponseEntity.ok(category);
    }
}
