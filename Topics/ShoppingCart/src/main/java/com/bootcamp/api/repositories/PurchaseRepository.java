package com.bootcamp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.api.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
