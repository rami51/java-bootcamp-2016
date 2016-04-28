package com.bootcamp.shoppingcart.apitest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.bootcamp.shoppingcart.api.Sale;
import com.bootcamp.shoppingcart.api.SaleItem;
import com.bootcamp.shoppingcart.api.ShoppingCart;
import com.bootcamp.shoppingcart.api.ShoppingCartFactory;

public class SaleTest {
Sale sale;
SaleItem item1;
SaleItem item2;
	@Before
	public void setUp() throws Exception {
		ShoppingCart cart = ShoppingCartFactory.getShoppingCart();
		//cart.add(new SaleItem(description, unitPrice, quantityOfThis));
		item1 = new SaleItem("T-Shirt", 5, 2);
		item2 = new SaleItem("Pants", 10, 1);
		cart.add(item1);
		cart.add(item2);
		sale = cart.buy();
	}

	@Test
	public void getTotalAmountTest() {
		assertTrue(sale.getTotalAmount() == (double)20);
	}
	
	@Test
	public void getSaleItemListTest(){
		ArrayList<SaleItem> list1 = new ArrayList<SaleItem>();
		list1.add(item1);
		list1.add(item2);
		ArrayList<SaleItem> list2 = sale.getSaleItemList();
		assertEquals(list1, list2);
	}

}
