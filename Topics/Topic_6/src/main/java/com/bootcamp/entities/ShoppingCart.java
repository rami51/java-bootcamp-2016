package com.bootcamp.entities;

import java.util.ArrayList;

import com.bootcamp.entities.Sale;
import com.bootcamp.entities.SaleItem;

public interface ShoppingCart {
	public boolean add(SaleItem saleItem);
	public boolean remove(SaleItem saleItem);
	public SaleItem getItem(int idItem);
	public Sale buy();
	public void clearCart();
	public double getTotal();
	public ArrayList<SaleItem> getItems();
}
