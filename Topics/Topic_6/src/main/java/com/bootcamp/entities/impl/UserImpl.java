package com.bootcamp.entities.impl;

import com.bootcamp.entities.ShoppingCart;
import com.bootcamp.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "The implementation of the User interface, which have the complete info for an user.")
public class UserImpl implements User {
	@ApiModelProperty(value="The user identifier.")
	private String idUser;
	@ApiModelProperty(value="The user name.")
	private String name;
	@ApiModelProperty(value="The user's Identification Number Document.")
	private int dni;
	@ApiModelProperty(value="The user's Shopping Cart.")
	private ShoppingCart cart;
	@JsonIgnore
	@ApiModelProperty(value="The user's password.")
	private String password;
	
	public UserImpl(String idUser, String password, String name, int dni) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.dni = dni;
		this.password = password;
		cart = new ShoppingCartImpl();
	}

	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public ShoppingCart getCart() {
		return cart;
	}	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + dni;
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserImpl other = (UserImpl) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (dni != other.dni)
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
}
