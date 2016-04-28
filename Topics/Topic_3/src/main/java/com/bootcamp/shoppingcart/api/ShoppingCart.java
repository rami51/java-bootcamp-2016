package com.bootcamp.shoppingcart.api;

public interface ShoppingCart {
	public void add(SaleItem saleItem);
	public boolean remove(SaleItem saleItem);
	public SaleItem getItem(int idItem);
	public Sale buy();
	public void cancelBuy();
	public double getTotal();
}
