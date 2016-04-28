package com.bootcamp.shoppingcart.api;

import java.util.ArrayList;

public class ShoppingCartImp implements ShoppingCart{
	private ArrayList<SaleItem> saleItemList;
	
	protected ShoppingCartImp(){
		saleItemList = new ArrayList<SaleItem>(); 
	}

	public void add(SaleItem saleItem) {
		saleItemList.add(saleItem);
	}

	public boolean remove(SaleItem saleItem) {
		return saleItemList.remove(saleItem);
	}

	public Sale buy() {
		return new Sale(saleItemList);
	}

	public void cancelBuy() {
		saleItemList.clear();
	}

	public double getTotal() {
		int totalAmount=0;
		for (SaleItem saleItem : saleItemList)
			totalAmount+=saleItem.getAmount();
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
	
}
