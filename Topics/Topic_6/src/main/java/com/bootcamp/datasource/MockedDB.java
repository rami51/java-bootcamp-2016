package com.bootcamp.datasource;

import java.util.ArrayList;
import java.util.List;

import com.bootcamp.entities.SaleItem;
import com.bootcamp.entities.User;
import com.bootcamp.entities.impl.UserImpl;

public class MockedDB {
	private static List<User> users = new ArrayList<User>();
	private static List<SaleItem> items = new ArrayList<SaleItem>();
	
	/**
	 * 
	 * @param idItem 
	 * @return This method may return null if it can't find the specified item.
	 */
	public static SaleItem findItemById(int idItem){
		init();
		for (SaleItem saleItem : items) {
			if (saleItem.getIdItem()==idItem) {
				return saleItem;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param idUser
	 * @return This method may return null if it can't find the specified user.
	 */
	public static User findUserbyId(String idUser){
		init();
		for (User user : users) {
			if (user.getIdUser().equals(idUser)) {
				return user;
			}
		}
		return null;
	}
	
	public static List<SaleItem> findAllItems(){
		init();
		return items;
	}
	
	public static List<User> findAllUsers(){
		init();
		return users;
	}
	
	private static void init(){
		if(users.isEmpty()) fillUsers();
		if(items.isEmpty()) fillItems();
	}

	private static void fillItems() {
		items.add(new SaleItem("Coke", 10));
		items.add(new SaleItem("Sprite", 10));
		items.add(new SaleItem("Fanta", 10));
		items.add(new SaleItem("Sandwich", 15));
		items.add(new SaleItem("Burger", 20));
		items.add(new SaleItem("Salad", 12));
		items.add(new SaleItem("Fruit Salad", 12));
	}

	private static void fillUsers() {
		users.add(new UserImpl("user1", "password", "Carlos", 111));
		users.add(new UserImpl("user2", "password", "Mario", 222));
		users.add(new UserImpl("user3", "password", "Eusebio", 333));
		users.add(new UserImpl("user4", "password", "Arnold", 444));
	}

}
