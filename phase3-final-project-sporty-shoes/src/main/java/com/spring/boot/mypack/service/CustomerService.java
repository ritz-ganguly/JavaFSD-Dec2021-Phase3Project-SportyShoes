package com.spring.boot.mypack.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.mypack.entity.Order;
import com.spring.boot.mypack.entity.Product;
import com.spring.boot.mypack.entity.User;
import com.spring.boot.mypack.repository.CustomerRepository;
import com.spring.boot.mypack.repository.OrderRepository;
import com.spring.boot.mypack.repository.ProductRepository;



@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductRepository productRepository;

	@Transactional
	public String customerSignup(User u){
	    try {
	    	boolean status = false;
	    	List<User> users = customerRepository.getAllUsers();
	    	for(User us:users) {
				if(us.getUserId().equals(u.getUserId()) ) {
					status =true;
					break;
					
				}
	    	}
	    	if(status  == false) {
		customerRepository.save(u);
		return "Signed up succesfully";
		
	    	}
	    	
	    	else
	    		return "Userid already exists";
	    }
	    catch(Exception e) {
	    	
	    	return "Some error occured";
	    }
		
	}
	
	
	
	
	
	@Transactional
	public boolean customerSignIn(User u){
		boolean status = false;
		try {
		List<User> users = customerRepository.getAllUsers();
		
		for(User us:users) {
			if(us.getUserId().equals(u.getUserId()) && us.getPassword().equals(u.getPassword())) {
				status =true;
				break;
				
			}
			
		}
		return status;
	    }
	    catch(Exception e) {
	    	
	    	return status;
	    }
		
	}
	
	
	@Transactional
	public User viewCustomerDetails(String userId) {
		
		return customerRepository.getUserDetails(userId);
	}
	
	
	@Transactional
	public User editCustomerDetails(String userId, User u) {
		u.setUserId(userId);
		u.setType("customer");
		return customerRepository.save(u);
	}
	
	
	
	
	@Transactional
	public String buyProduct(Product p, int quantity,String userId) {
		Order order = new Order();
		order.setDeliveryDate(LocalDate.now().plusDays(3));
		order.setOrderDate(LocalDate.now());
		String status = "in transit";
		order.setStatus(status);
		order.setProduct(p);
		User u = new User();
		u.setUserId(userId);
		order.setUser(u);
		System.out.println(order);
		orderRepository.save(order);
		
		int availableQuantity = p.getProductQuantity();
		int newQuantity=  availableQuantity - quantity;
		p.setProductQuantity(newQuantity);
		productRepository.save(p);
		
		return "Product bought Succesfully";
	    
		
	}
	
	
	@Transactional
	public List<Order> userPurchaseHistory(String userId){
		
		List<Order> ord = orderRepository.userPurchaseHistory(userId);
		
		
		return ord;
		   
	}
}
