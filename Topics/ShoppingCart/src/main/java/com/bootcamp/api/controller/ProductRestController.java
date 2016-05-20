package com.bootcamp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.api.entities.Category;
import com.bootcamp.api.entities.Product;
import com.bootcamp.api.services.CategoryService;
import com.bootcamp.api.services.ProductService;
import com.wordnik.swagger.annotations.Api;

@RestController
@RequestMapping("/products")
@Api(value = "Products", description = "Products API")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAll() {
		List<Product> products = productService.getAll();
		if (!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{idProduct}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable Integer idProduct) {
		Product product = productService.getById(idProduct);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/byDescription/{description}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable String description) {
		Product product = productService.getByDescription(description);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product, @RequestParam Integer idCategory) {
		Category category = categoryService.getById(idCategory);
		product.setCategory(category);
		Product toReturn = productService.add(product);
		if (toReturn != null) {
			return new ResponseEntity<Product>(toReturn, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		Product toReturn = productService.update(product);
		if(toReturn !=null){
			return new ResponseEntity<Product>(toReturn, HttpStatus.OK);
		} else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> removeProduct (@RequestParam Integer idProduct){
		Product product = productService.getById(idProduct);
		try{
		productService.remove(product);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}