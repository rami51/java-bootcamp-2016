package com.bootcamp.shoppingcart.api;

public class SaleItem {
	private static int lastId = 0;
	private int idItem;
	private String description;
	private double unitPrice;
	private int quantityOfThis;


	public SaleItem(String description, double unitPrice, int quantityOfThis){
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantityOfThis = quantityOfThis;
		this.idItem = ++lastId;
	}

	public int getIdItem() {
		return idItem;
	}

	public String getDescription() {
		return description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getQuantityOfThis() {
		return quantityOfThis;
	}
	
	public double getAmount(){
		return (unitPrice * (double)quantityOfThis);
	}
}
