package com.bootcamp.api.services;

import java.util.List;

import com.bootcamp.api.entities.Category;

public interface CategoryService {
	public Category getById(Integer idCategory);
	
	public Category getByDescription(String description);

	public List<Category> getAll();

	public Category add(Category category);

	public void remove(Category category);

	public Category update(Category category);
}
