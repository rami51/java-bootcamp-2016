package com.bootcamp.shoppingcart.apitest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bootcamp.shoppingcart.api.SaleItem;


public class SaleItemTest {
	SaleItem item;
	@Before
	public void setUp() throws Exception {
		item = new SaleItem("A product", 10, 3);
	}
	
	@Test
	public void getAmountTest(){
		assertTrue(30 == item.getAmount());
	}

}
