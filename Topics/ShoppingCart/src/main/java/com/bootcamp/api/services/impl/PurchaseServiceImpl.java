package com.bootcamp.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.api.entities.Purchase;
import com.bootcamp.api.repositories.PurchaseRepository;
import com.bootcamp.api.services.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public Purchase add(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}


	
}
