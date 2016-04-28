package com.bootcamp.shoppingcart.api;

import java.util.ArrayList;

public class Sale {
	private ArrayList<SaleItem> saleItemList;
	private double totalAmount=0;
	
	//This constructor is protected because the client only can has a sale if he use a ShoppingCart object.
	protected Sale(ArrayList<SaleItem> saleItemList){ 
		this.saleItemList = saleItemList;
	}
	
	public double getTotalAmount(){
		if(totalAmount==0)
			for (SaleItem saleItem : saleItemList)
				totalAmount+=saleItem.getAmount();
		return totalAmount;
	}
	
	public ArrayList<SaleItem> getSaleItemList(){
		return saleItemList;
	}
}
