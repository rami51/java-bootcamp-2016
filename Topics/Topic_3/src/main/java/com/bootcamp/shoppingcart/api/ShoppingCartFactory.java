package com.bootcamp.shoppingcart.api;

public class ShoppingCartFactory {
	private ShoppingCartFactory(){
	}
	
	public static ShoppingCart getShoppingCart(){
		return new ShoppingCartService();
	}
}
