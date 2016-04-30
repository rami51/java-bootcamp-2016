package com.bootcamp.shoppingcart.api;

public class SaleItem {
	private static int lastId = 0;
	private int idItem;
	private String description;
	private double unitPrice;



	public SaleItem(String description, double unitPrice){
		this.description = description;
		this.unitPrice = unitPrice;

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
}
