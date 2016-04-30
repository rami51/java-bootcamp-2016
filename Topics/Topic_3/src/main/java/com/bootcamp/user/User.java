package com.bootcamp.user;

import com.bootcamp.shoppingcart.api.Sale;
import com.bootcamp.shoppingcart.api.SaleItem;
import com.bootcamp.shoppingcart.api.ShoppingCart;

public interface User {
	public void addToCart(SaleItem saleItem);
	public boolean removeFromCart(SaleItem saleItem);
	public Sale buyCartContent();
	public void clearCart();
	public double getTotalOfCart();
}
