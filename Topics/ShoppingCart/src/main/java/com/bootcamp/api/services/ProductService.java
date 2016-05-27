package com.bootcamp.api.services;

import java.util.List;

import com.bootcamp.api.entities.Category;
import com.bootcamp.api.entities.Product;

public interface ProductService {
	public Product getById(Integer idProduct);

	public Product getByDescription(String description);

	public List<Product> getAll();

	public List<Product> getByCategory(Category category);

	public void remove(Product product);

	public Product update(Product product);

	public Product add(Product product);
}
