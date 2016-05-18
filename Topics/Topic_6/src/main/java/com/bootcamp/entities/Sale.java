package com.bootcamp.entities;

import java.util.ArrayList;

public class Sale {
	private ArrayList<SaleItem> saleItemList;
	private double totalAmount;
	
	//This constructor is protected because the client only can has a sale if he use a ShoppingCart object.
	public Sale(ArrayList<SaleItem> saleItemList, double total){
		this.saleItemList = saleItemList;
		totalAmount = total;
	}
	
	public double getTotalAmount(){
		return totalAmount;
	}
	
	public ArrayList<SaleItem> getSaleItemList(){
		return saleItemList;
	}
}
