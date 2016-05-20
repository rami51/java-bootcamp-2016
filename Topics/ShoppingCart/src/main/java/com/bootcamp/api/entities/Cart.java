package com.bootcamp.api.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Cart entity", description = "Complete info of a entity Cart.")
public class Cart {
	@ApiModelProperty(value = "The ID of the cart.")
	@Id
	@GeneratedValue
	private Integer idCart;

	@ApiModelProperty(value = "The user owner of the cart.")
	@JsonIgnore
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUser")
	private User user;

	@ApiModelProperty(value = "The product list of the cart.")
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product> products;

	public Cart() {
	}

	public Cart(User user) {
		products = new ArrayList<Product>();
		this.user = user;
	}

	/**
	 * 
	 * @return A List which contains the Product objects in the Cart.
	 */
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getIdCart() {
		return idCart;
	}

	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @param idProduct
	 *            is the idProduct field of the Product object in search.
	 * @return The specified Product object if it exists, otherwise returns
	 *         null.
	 */
	public Product getProduct(int idProduct) {
		for (Product product : products) {
			if ((int) product.getIdProduct() == idProduct) {
				return product;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param product
	 *            is the Product object to add to Cart.
	 * @return True if the Cart content has changed as a result of the call.
	 */
	public boolean add(Product product) {
		return products.add(product);
	}

	/**
	 * 
	 * @param product
	 *            is the Product object to remove from Cart.
	 * @return True if a Product was removed from Cart.
	 */
	public boolean remove(Product product) {
		return products.remove(product);
	}

	/**
	 * This method removes all the Product objects from Cart. Leaves it empty.
	 */
	public void clear() {
		products.clear();
	}

	/**
	 * 
	 * @return True if Cart does not contain any Product, otherwise returns
	 *         false.
	 */
	public boolean isEmpty() {
		return products.isEmpty();
	}

	/**
	 * This method instantiates a new Purchase object, and clears the Cart.
	 * 
	 * @return The Purchase object instantiated.
	 */
	public Purchase buy() {
		ArrayList<Product> toReturn = new ArrayList<Product>();
		for (Product product : products) {
			product.setStock(product.getStock()-1);
			toReturn.add(product);
		}
		products.clear();
		Purchase purchase = new Purchase(user, Date.valueOf(LocalDate.now()), toReturn);
		user.getPurchases().add(purchase);
		return purchase;
	}

}
