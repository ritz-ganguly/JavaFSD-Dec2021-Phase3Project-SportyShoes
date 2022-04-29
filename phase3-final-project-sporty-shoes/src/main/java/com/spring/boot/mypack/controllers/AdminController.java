package com.spring.boot.mypack.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.mypack.entity.Order;
import com.spring.boot.mypack.entity.Product;
import com.spring.boot.mypack.entity.User;
import com.spring.boot.mypack.service.AdminService;
import com.spring.boot.mypack.service.CustomerService;
import com.spring.boot.mypack.service.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	ProductService productService;
	@Autowired
	CustomerService customerService;
	@Autowired
	AdminService adminService;
	
	@PostMapping("/signIn")
	public String userSignIn(@RequestBody User user,HttpSession session) {
		
		boolean status = adminService.adminSignIn(user);
		
		if(status == false)
			return "Check Username/Password";
		else {
			session.setAttribute("adminUserId", user.getUserId());
			return "Hello "+ session.getAttribute("adminUserId")+ " Signed In succesfully";
			
		}
		
		
	}
	
	
	
	@PostMapping("/signOut")
	public String userSignOut(HttpSession session) {
		
		    if(session.getAttribute("adminUserId") !=null) {
			session.invalidate();
			return "Signed Out Successfully at " +LocalDate.now();
		    }
		   return null;
		
		
	}
	
	
	@PostMapping("/editAdminPassword")
	public String editUserDetails(HttpSession session, @RequestBody User u) {
		if(session.getAttribute("adminUserId") !=null) {
			 try {
			 adminService.editAdminPassword((String )session.getAttribute("adminUserId"),u);
			 return "Profile changes succesful";
			 }
			 
			 catch(Exception e) {
				 
				 return "some error occured while making changes";
			 }
		}
		return "some error occured while making changes";
	}
	
	
	
	
	
	@PostMapping("/getAllUsers")
	public List<User> getAllUSers(HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
			 
			 return adminService.getAllUsers();
		}
				 
		else  return null;
			
		
		
	}
	
	
	
	
	@PostMapping("/findUsersByName")
	public List<User> getUsersByName(@RequestBody User u, HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
		return adminService.getUsersByName(u.getName().strip());
		
		}
		return null;
	}
	
	
	
	@PostMapping("/findUsersById")
	public List<User> getUsersById(@RequestBody User u, HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
		return adminService.getUsersById(u.getUserId().strip());
		
		}
		return null;
	}
	
	
	
	
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
		List<Product> products = productService.getAllProducts();
		
	
		return products;
		
		}
		return null;
		
		
	}
	
	
	
	@PostMapping("/findProductById")
	public List<Product> getProductById(@RequestBody Product product, HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
		return productService.getProductById(product.getProductNumber().strip());
		}
		return null;
		
	}
	
	
	
	
	
	@PostMapping("/findOrdersByProductId")
	public List<Order> getOrdersByProductId(@RequestBody Product product, HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
		return adminService.getOrdersByProductId(product.getproductId());
		
		}
		
		return null;
	}
	
	
	
	
	
	@PostMapping("/findOrdersByUserId")
	public List<Order> getOrdersByUserId(@RequestBody User user, HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
		return adminService.getOrdersByUserId(user.getUserId().strip());
		}
		return null;
	}
	
	
	
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product p, HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
		adminService.addProduct(p);
		return "Product added succesfully";
		}
		
		return null;
		
	}
	
	//while sending data for this from UI, don't forget to embed productId attribute
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody Product p, HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
		adminService.addProduct(p);
		return "Product updated succesfully";
		}
		
		return null;
		
	}
	
	//While sending data for this from UI, don't forget to embed productId attribute
	@PostMapping("/deleteProduct")
	public String deleteProduct(@RequestBody Product p, HttpSession session) {
		if(session.getAttribute("adminUserId") !=null) {
		adminService.deleteProduct(p);
		return "Product deleted succesfully";
		}
		
		return null;
		
	}
	
	
	
	
	
	
	@PostMapping("/sortByOrderDateAsc")
	public List<Order> sortByOrderDateAsc(HttpSession session)
	{
		if(session.getAttribute("adminUserId") !=null) {
		
			return adminService.sortByOrderDateAsc();
		}
		
		return null;
		
		
	}
	
	
	
	@PostMapping("/sortByOrderDateDesc")
	public List<Order> sortByOrderDateDesc(HttpSession session)
	{
		if(session.getAttribute("adminUserId") !=null) {
		
			return adminService.sortByOrderDateDesc();
		}
		
		return null;
		
		
	}
	
	
	
	
	@PostMapping("/sortByOrderIdAsc")
	public List<Order> sortByOrderIdAsc(HttpSession session)
	{
		if(session.getAttribute("adminUserId") !=null) {
		
			return adminService.sortByOrderIdAsc();
		}
		
		return null;
		
		
	}
	
	
	
	@PostMapping("/sortByOrderIdDesc")
	public List<Order> sortByOrderIdDesc(HttpSession session)
	{
		if(session.getAttribute("adminUserId") !=null) {
		
			return adminService.sortByOrderIdDesc();
		}
		
		return null;
		
		
	}
	
	
	
	@PostMapping("/deleteOrderById")
	public void deleteOrderById(@RequestBody Order o, HttpSession session)
	{
		if(session.getAttribute("adminUserId") !=null) {
		      
			adminService.deleteOrderById(o.getOrderId());
			
			
		}
		
		
		
		
	}
	
}
