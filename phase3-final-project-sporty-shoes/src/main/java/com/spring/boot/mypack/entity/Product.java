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

@Entity(name= "prod")
@Table(name="product")
public class Product implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "product_id",unique = true)
	private int productId;
	
	@Column(name = "product_number")
	private String productNumber;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "product_vendor")
	private String productVendor;
	
	@Column(name = "product_category")
	private String productCategory;
	
	@OneToMany(mappedBy="product",fetch = FetchType.EAGER, 
			
			targetEntity=Order.class)
	
	@JsonIgnoreProperties("product")
	private List<Order> orders = new ArrayList<>();
	
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public int getproductId() {
		return productId;
	}


	public void setProductId(int id) {
		this.productId = id;
	}


	public String getProductNumber() {
		return productNumber;
	}


	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public String getProductVendor() {
		return productVendor;
	}


	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
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
