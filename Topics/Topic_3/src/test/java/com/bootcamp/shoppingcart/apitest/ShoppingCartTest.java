package com.bootcamp.shoppingcart.apitest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bootcamp.shoppingcart.api.Sale;
import com.bootcamp.shoppingcart.api.SaleItem;
import com.bootcamp.shoppingcart.api.ShoppingCart;
import com.bootcamp.shoppingcart.api.ShoppingCartFactory;

public class ShoppingCartTest {
	ShoppingCart cart;
	SaleItem item;
	@Before
	public void setUp() throws Exception {
		cart = ShoppingCartFactory.getShoppingCart();
		//cart.add(new SaleItem(description, unitPrice, quantityOfThis));
		item = new SaleItem("T-Shirt", 5, 2);
		cart.add(item);
		cart.add(new SaleItem("Pants", 10, 1));
	}

	@Test
	public void addAndGetTotalTest() {
		cart.add(new SaleItem("Shoes", 15, 1));
		assertTrue(cart.getTotal() == (double)35);
	}
	
	@Test
	public void GetAndRemoveTest() {
		SaleItem auxItem = cart.getItem(item.getIdItem());
		cart.remove(auxItem);
		assertTrue(cart.getTotal() == (double)10);
	}
	
	@Test
	public void buyTest(){
		Sale sale = cart.buy();
		assertTrue(sale.getTotalAmount()== (double)20);
	}
	
	@Test
	public void cancelBuyTest(){
		cart.cancelBuy();
		assertTrue(cart.getTotal()== 0);
	}

}
