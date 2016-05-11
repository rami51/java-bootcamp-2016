package com.bootcamp.services;

import com.bootcamp.entities.SaleItem;

public interface ServiceSaleItem {
	public SaleItem getSaleItemById(int idItem);
	public boolean updateSaleItem(SaleItem saleItem);
	public boolean addSaleItem(SaleItem saleItem);
	public boolean deleteSaleItem(int idItem);
}
