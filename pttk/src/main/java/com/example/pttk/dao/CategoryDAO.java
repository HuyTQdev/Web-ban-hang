package com.example.pttk.dao;

import java.util.List;

import com.example.pttk.model.Category;

public interface CategoryDAO {

	/**
	 * 
	 * @param category
	 */
	void AddCategory(Category category);

	/**
	 * 
	 * @param category
	 */
	void EditCategory(Category category);

	/**
	 * 
	 * @param category
	 */
	void DeleteCategory(Category category);

	List<Category> SelectAllCategories();

	Category SelectCategory();

}