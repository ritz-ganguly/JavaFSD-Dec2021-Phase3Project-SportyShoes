package com.spring.boot.mypack.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "us")
@Table(name="user")
public class User  implements Serializable{
	@Id
	
	@Column(name= "user_id",unique = true)
	private String userId;
	
	@Column(name= "password")
	private String password;
	
	@Column(name= "name")
	private String name;
	
	
	@Column(name= "type")
	private String type;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER, 
			
			 targetEntity=Order.class)
	@JsonIgnoreProperties("user")
	
	
	private List<Order> orders = new ArrayList<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void addOrder(Order order) {
		orders.add(order);
	}

	
	public void removeOrder(Order order)
	
	{
		
		orders.remove(order);
	}


	


	


	


	


	

	

	
	
	
	
	
	
	
	
	
}
