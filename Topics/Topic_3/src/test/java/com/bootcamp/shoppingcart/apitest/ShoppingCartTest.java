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
		item = new SaleItem("T-Shirt", 5);
		cart.add(item);
		cart.add(new SaleItem("Pants", 10));
	}

	@Test
	public void addAndGetTotalTest() {
		cart.add(new SaleItem("Shoes", 15));
		assertTrue(cart.getTotal() == (double)30);
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
		assertTrue(sale.getTotalAmount()== (double)15);
	}
	
	@Test
	public void cancelBuyTest(){
		cart.clearCart();
		assertTrue(cart.getTotal()== 0);
	}

}
