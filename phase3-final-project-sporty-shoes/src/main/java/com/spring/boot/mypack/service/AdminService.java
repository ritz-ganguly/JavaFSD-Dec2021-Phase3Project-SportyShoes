package com.spring.boot.mypack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.mypack.entity.Order;
import com.spring.boot.mypack.entity.Product;
import com.spring.boot.mypack.entity.User;
import com.spring.boot.mypack.repository.AdminRepository;
import com.spring.boot.mypack.repository.CustomerRepository;
import com.spring.boot.mypack.repository.OrderRepository;
import com.spring.boot.mypack.repository.ProductRepository;

@Service
public class AdminService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	AdminRepository adminRepository;
	
	
	@Transactional
	public boolean adminSignIn(User u){
		boolean status = false;
		try {
		List<User> users = adminRepository.getAllAdmins();
		
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
	public User editAdminPassword(String userId, User u) {
		u.setUserId(userId);
		u.setType("admin");
		return adminRepository.save(u);
	}
	
	
	
	@Transactional
	public List<User> getAllUsers() {
		
		return adminRepository.getAllUsers();
	}
	
	
	
	@Transactional
	public List<User> getUsersByName(String name) {
		
		return adminRepository.getUsersByName(name);
	}
	
	
	
	@Transactional
	public List<User> getUsersById(String userId) {
		
		return adminRepository.getUsersById(userId);
	}
	
	
	
	
	
	
	@Transactional
	public List<Order> getOrdersByProductId(int productId) {
		
		return orderRepository.getOrdersByProductId(productId);
	}
	
	
	
	
	
	
	@Transactional
	public List<Order> getOrdersByUserId(String userId) {
		
		return orderRepository.getOrdersByUserId(userId);
	}
	
	
	@Transactional
	public void addProduct(Product p) {
		
		productRepository.save(p);
		
	}
	
	
	
	
	@Transactional
	public void deleteProduct(Product p) {
		
		productRepository.delete(p);
		
	}
	
	@Transactional
	public List<Order> sortByOrderDateAsc()
	
	{
		
		return orderRepository.sortByOrderDateAsc();
		
	}
	
	
	
	@Transactional
	public List<Order> sortByOrderDateDesc()
	
	{
		
		return orderRepository.sortByOrderDateDesc();
		
	}
	
	
	
	
	
	
	@Transactional
	public List<Order> sortByOrderIdAsc()
	
	{
		
		return orderRepository.sortByOrderIdAsc();
		
	}
	
	
	
	
	@Transactional
	public List<Order> sortByOrderIdDesc()
	
	{
		
		return orderRepository.sortByOrderIdDesc();
		
	}
	
	
	
	@Transactional
	public void deleteOrderById(int orderId)
	
	{
		
		orderRepository.deleteById(orderId);
		
		
		
		
		
	}
}
