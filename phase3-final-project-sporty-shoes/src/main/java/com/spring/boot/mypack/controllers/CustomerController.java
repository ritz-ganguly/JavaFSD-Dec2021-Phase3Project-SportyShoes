package com.spring.boot.mypack.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.mypack.entity.Order;
import com.spring.boot.mypack.entity.Product;
import com.spring.boot.mypack.entity.User;
import com.spring.boot.mypack.repository.OrderRepository;
import com.spring.boot.mypack.repository.ProductRepository;
import com.spring.boot.mypack.service.CustomerService;
import com.spring.boot.mypack.service.ProductService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ProductService productService;
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		
		List<Product> products = productService.getAllProducts();
		
		System.out.println(products);
		return products;
		
		
	}
	
	@PostMapping("/signUp")
	public String userSignup(@RequestBody User user) {
		
		return customerService.customerSignup(user);
		
		
	}
	
	
	@PostMapping("/signIn")
	public String userSignIn(@RequestBody User user,HttpSession session) {
		
		boolean status = customerService.customerSignIn(user);
		
		if(status == false)
			return "Check Username/Password";
		else {
			session.setAttribute("customerUserId", user.getUserId());
			return "Hello "+ session.getAttribute("customerUserId")+ " Signed In succesfully";
			
		}
		
		
	}
	
	
	@PostMapping("/signOut")
	public String userSignOut(HttpSession session) {
		
		    if(session.getAttribute("customerUserId") !=null) {
			session.invalidate();
			return "Signed Out Successfully at " +LocalDate.now();
		    }
		   return null;
		
		
	}
	
	
	@PostMapping("/findProductByName")
	public List<Product> getProductByName(@RequestBody Product product) {
		
		return productService.getProductByName(product.getProductName().strip());
		
		
	}
	
	@PostMapping("/findProductById")
	public List<Product> getProductBId(@RequestBody Product product) {
		
		return productService.getProductById(product.getProductNumber().strip());
		
		
	}
	
	@PostMapping("/getUserDetails")
	public User getUserDetails(HttpSession session) {
		if(session.getAttribute("customerUserId") !=null) {
			
			return customerService.viewCustomerDetails((String )session.getAttribute("customerUserId"));
		
		}
		return null;
	}
	
	
	@PostMapping("/editUserDetails")
	public String editUserDetails(HttpSession session, @RequestBody User u) {
		if(session.getAttribute("customerUserId") !=null) {
			 try {
			 customerService.editCustomerDetails((String )session.getAttribute("customerUserId"),u);
			 return "Profile changes succesful";
			 }
			 
			 catch(Exception e) {
				 
				 return "some error occured while making changes";
			 }
		}
		return "some error occured while making changes";
	}
	
	
	@PostMapping("/buyProduct")
	public String buyProduct(HttpSession session,@RequestBody Product p,
			@RequestParam(name="quantity") int quantity) {
		
		System.out.println(quantity);
		if(session.getAttribute("customerUserId") !=null) {
			String msg = customerService.buyProduct(p, quantity,
					(String) session.getAttribute("customerUserId") );
			
		  return msg;
		}
		return null;
	}
	
	
	
	
	
	
	@PostMapping("/purchaseHistory")
	public  List<Order> userPurchaseHistory(HttpSession session) {
		
		
		if(session.getAttribute("customerUserId") !=null) {
			List<Order> order = customerService.userPurchaseHistory
					((String) session.getAttribute("customerUserId") );
			
		  
		    return order;
			
			
			
	}
		
		return null;
		
	}
}
