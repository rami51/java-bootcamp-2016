package com.bootcamp.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.api.entities.Category;
import com.bootcamp.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByDescription(String description);

	List<Product> findByCategory(Category category);

}
