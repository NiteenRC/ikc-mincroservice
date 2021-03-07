package com.nc.common;

public class Category {

	private Long id;
	private String categoryName;

	public Category() {
	}

	public Category(Long id, String categoryName) {
		this.id = id;
		this.categoryName = categoryName;
	}

	public String getcategoryName() {
		return categoryName;
	}

	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
