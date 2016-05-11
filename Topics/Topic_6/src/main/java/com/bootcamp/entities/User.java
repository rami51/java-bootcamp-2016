package com.bootcamp.entities;

public interface User {
	public String getPassword();
	public void setPassword(String password);
	public String getIdUser();
	public void setIdUser(String idUser);
	public String getName();
	public void setName(String name);
	public int getDni();
	public void setDni(int dni);
	public ShoppingCart getCart();
	public int hashCode();
	public boolean equals(Object obj);
}
