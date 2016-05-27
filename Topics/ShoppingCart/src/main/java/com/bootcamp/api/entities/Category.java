package com.bootcamp.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Category entity", description = "Complete info of a entity Category.")
public class Category {
	@ApiModelProperty(value = "The ID of the category.")
	@Id
	@GeneratedValue
	private Integer idCategory;

	@ApiModelProperty(value = "The description of the category.")
	private String description;

	@ApiModelProperty(value = "The product list of the category.")
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;

	public Category(){
	}
	
	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Product getProduct(Integer idProduct){
		for (Product product : products) {
			if (product.getIdProduct() == (int)idProduct) {
				return product;
			}
		}
		return null;
	}
	
	public Product updateProduct(Product product){
		Product toUpdate = this.getProduct(product.getIdProduct());
		if (toUpdate != null) {
			toUpdate.setDescription(product.getDescription());
			toUpdate.setPrice(product.getPrice());
			toUpdate.setStock(product.getStock());
			return toUpdate;
		} else return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idCategory == null) ? 0 : idCategory.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idCategory == null) {
			if (other.idCategory != null)
				return false;
		} else if (!idCategory.equals(other.idCategory))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

}
