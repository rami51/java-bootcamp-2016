package com.bootcamp.entities.impl;

import java.util.ArrayList;

import com.bootcamp.entities.SaleItem;
import com.bootcamp.entities.ShoppingCart;
import com.bootcamp.entities.Sale;

public class ShoppingCartImpl implements ShoppingCart{
	private ArrayList<SaleItem> saleItemList;
	
	public ShoppingCartImpl(){
		saleItemList = new ArrayList<SaleItem>(); 
	}

	public boolean add(SaleItem saleItem) {
		return saleItemList.add(saleItem);
	}

	public boolean remove(SaleItem saleItem) {
		return saleItemList.remove(saleItem);
	}

	public Sale buy() {
		ArrayList<SaleItem> toReturn = new ArrayList<SaleItem>();
		for (SaleItem saleItem : saleItemList) {
			toReturn.add(saleItem);
		}
		return new Sale(toReturn, this.getTotal());
	}

	public double getTotal() {
		int totalAmount=0;
		for (SaleItem saleItem : saleItemList)
			totalAmount+=saleItem.getUnitPrice();
		return totalAmount;
	}

	public SaleItem getItem(int idItem) {
		for (SaleItem saleItem : saleItemList) {
			if (saleItem.getIdItem() == idItem) {
				return saleItem;
			}
		}
		return null;
	}

	public void clearCart() {
		saleItemList.clear();		
	}

	@Override
	public ArrayList<SaleItem> getItems() {
		return saleItemList;
	}

}
