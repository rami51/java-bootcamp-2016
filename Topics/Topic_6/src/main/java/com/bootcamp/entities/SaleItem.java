package com.bootcamp.entities;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value= "SaleItem Entity", description="Complete info of a SaleItem Entity")
public class SaleItem {
	@ApiModelProperty(value="A static field which increases by one when the class is instantiated.")
	private static int lastId = 0;
	@ApiModelProperty(value="The item identifier.")
	private int idItem;
	@ApiModelProperty(value="The item description.")
	private String description;
	@ApiModelProperty(value="The item unit price.")
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
