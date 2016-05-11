package com.bootcamp.user;

import com.bootcamp.shoppingcart.api.Sale;
import com.bootcamp.shoppingcart.api.SaleItem;
import com.bootcamp.shoppingcart.api.ShoppingCart;
import com.bootcamp.shoppingcart.api.ShoppingCartFactory;

public class UserService implements User {
	private String name;
	private String lastName;
	private int document;
	private ShoppingCart cart;
	
	public UserService(){
		cart = ShoppingCartFactory.getShoppingCart();
	}

	public void addToCart(SaleItem saleItem) {
		cart.add(saleItem);		
	}

	public boolean removeFromCart(SaleItem saleItem) {
		return cart.remove(saleItem);
	}

	public Sale buyCartContent() {
		return cart.buy();
	}

	public void clearCart() {
		cart.clearCart();
	}

	public double getTotalOfCart() {
		return cart.getTotal();
	}

}
