package com.bootcamp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByDescription(String description);

}
