package com.spring.boot.mypack.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity(name = "ord")
@Table(name="orders")
public class Order implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "order_id")
	private int orderId;
	
	@Column(name= "order_date")
	private LocalDate orderDate;
	
	
	@Column(name= "delivery_date")
	private LocalDate deliveryDate;
	
	
	@Column(name= "status")
	private String status;
	
	
	@ManyToOne(fetch = FetchType.EAGER )
	
	@JoinColumn(name = "product_id")
	@JsonIgnoreProperties("orders")
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER )
	
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("orders")
	
	private User user;
	
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
   
	
	public Order(LocalDate orderDate, LocalDate deliveryDate, String status) {
		
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate localDate) {
		this.deliveryDate = localDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	






	


	

	
	
	
	
	
}
