package com.bootcamp.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.api.entities.Category;
import com.bootcamp.api.repositories.CategoryRepository;
import com.bootcamp.api.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryServiceImpl() {
	}

	@Override
	public Category getByDescription(String description) {
		return categoryRepository.findByDescription(description);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category add(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void remove(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getById(Integer idCategory) {
		return categoryRepository.findOne(idCategory);
	}

}
