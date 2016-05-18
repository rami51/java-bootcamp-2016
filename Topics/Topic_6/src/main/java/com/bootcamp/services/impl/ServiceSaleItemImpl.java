package com.bootcamp.services.impl;

import org.springframework.stereotype.Service;

import com.bootcamp.dao.SaleItemDAO;
import com.bootcamp.dao.impl.SaleItemDAOImpl;
import com.bootcamp.entities.SaleItem;
import com.bootcamp.services.ServiceSaleItem;

@Service
public class ServiceSaleItemImpl implements ServiceSaleItem {
	private SaleItemDAO saleItemDAO;
	
	public ServiceSaleItemImpl(){
		saleItemDAO = new SaleItemDAOImpl();
	}
	@Override
	public SaleItem getSaleItemById(int idItem) {
		return saleItemDAO.getSaleItemById(idItem);
	}

	@Override
	public boolean updateSaleItem(SaleItem saleItem) {
		return saleItemDAO.updateSaleItem(saleItem);
	}

	@Override
	public boolean addSaleItem(SaleItem saleItem) {
		return saleItemDAO.addSaleItem(saleItem);
	}

	@Override
	public boolean deleteSaleItem(int idItem) {
		return saleItemDAO.deleteSaleItem(idItem);
	}

}
