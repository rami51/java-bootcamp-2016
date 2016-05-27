package com.bootcamp.api.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Purchase entity", description = "Complete info of a entity Purchase.")
public class Purchase {
	@ApiModelProperty(value = "The ID of the purchase.")
	@Id
	@GeneratedValue
	private Integer idPurchase;

	@ApiModelProperty(value = "The user owner of the purchase.")
	@JsonIgnore
	@JoinColumn(name = "idUser")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@ApiModelProperty(value = "The date of the purchase.")
	private Date date;

	@ApiModelProperty(value = "The product list of the purchase.")
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Product> products;

	@ApiModelProperty(value = "The total amount of the purchase.")
	private double total;

	protected Purchase(){
		
	}
	
	public Purchase(User user, Date date, List<Product> products) {
		this.user = user;
		this.date = date;
		this.products = products;
		for (Product product : products) {
			total += product.getPrice();
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIdPurchase() {
		return idPurchase;
	}

	public User getUser() {
		return user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((idPurchase == null) ? 0 : idPurchase.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Purchase other = (Purchase) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idPurchase == null) {
			if (other.idPurchase != null)
				return false;
		} else if (!idPurchase.equals(other.idPurchase))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
