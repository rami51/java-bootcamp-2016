package com.bootcamp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.api.entities.Category;
import com.bootcamp.api.entities.Product;
import com.bootcamp.api.services.CategoryService;
import com.wordnik.swagger.annotations.Api;

@RestController
@RequestMapping("/categories")
@Api(value = "Categories", description = "Categories of Products API")
public class CategoryRestController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categories = categoryService.getAll();
		if (!categories.isEmpty()) {
			return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> removeCategory(@RequestBody Category category) {
		Category categorytest = categoryService.getById(category.getIdCategory());
		if (categorytest != null) {
			categoryService.remove(category);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		if (categoryService.getById(category.getIdCategory()) != null) {
			return new ResponseEntity<Category>(categoryService.update(category), HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.add(category), HttpStatus.OK);
	}

	@RequestMapping(value = "/{idCategory}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer idCategory) {
		Category category = categoryService.getById(idCategory);
		if (category != null) {
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{idCategory}/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Integer idCategory) {
		Category category = categoryService.getById(idCategory);
		if (category != null) {
			return new ResponseEntity<List<Product>>(category.getProducts(), HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{idCategory}/products", method = RequestMethod.POST)
	public ResponseEntity<List<Product>> addProductToCategory(@PathVariable Integer idCategory, @RequestBody Product product) {
		Category category = categoryService.getById(idCategory);
		if (category != null) {
			category.getProducts().add(product);
			Category updated = categoryService.update(category);
			return new ResponseEntity<List<Product>>(updated.getProducts(), HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(value = "/{idCategory}/products", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProductFromCategory(@PathVariable Integer idCategory, @RequestBody Product product) {
		Category category = categoryService.getById(idCategory);
		if (category != null) {
			Product updatedProduct = category.updateProduct(product);
			categoryService.update(category);
			return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	@RequestMapping(value = "/{idCategory}/products", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeProductFromCategory(@PathVariable Integer idCategory, @RequestBody Product product) {
		Category category = categoryService.getById(idCategory);
		if (category != null) {
			if (category.getProducts().remove(product)) {
				categoryService.update(category);
				return new ResponseEntity<>(HttpStatus.OK);
			} else
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
