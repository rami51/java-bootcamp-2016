package com.bootcamp.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.api.entities.Category;
import com.bootcamp.api.entities.Product;
import com.bootcamp.api.repositories.ProductRepository;
import com.bootcamp.api.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	public ProductServiceImpl() {
	}

	@Override
	public Product getById(Integer idProduct) {
		return productRepository.findOne(idProduct);
	}

	@Override
	public Product getByDescription(String description) {
		return productRepository.findByDescription(description);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public void remove(Product product) {
		productRepository.delete(product);
	}

	@Override
	public Product update(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product add(Product product) {
		return productRepository.save(product);
	}

}
