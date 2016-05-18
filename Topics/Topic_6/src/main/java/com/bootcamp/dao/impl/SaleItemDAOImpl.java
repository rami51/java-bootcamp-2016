package com.bootcamp.dao.impl;

import com.bootcamp.dao.SaleItemDAO;
import com.bootcamp.datasource.MockedDB;
import com.bootcamp.entities.SaleItem;

public class SaleItemDAOImpl implements SaleItemDAO {

	@Override
	public SaleItem getSaleItemById(int idItem) {
		return MockedDB.findItemById(idItem);
	}

	@Override
	public boolean updateSaleItem(SaleItem saleItem) {
		for (SaleItem i : MockedDB.findAllItems()) {
			if (i.getIdItem() == saleItem.getIdItem()) {
				i = saleItem;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addSaleItem(SaleItem saleItem) {
		return MockedDB.findAllItems().add(saleItem);
	}

	@Override
	public boolean deleteSaleItem(int idItem) {
		SaleItem saleItem = MockedDB.findItemById(idItem);
		return MockedDB.findAllItems().remove(saleItem);
	}

}
