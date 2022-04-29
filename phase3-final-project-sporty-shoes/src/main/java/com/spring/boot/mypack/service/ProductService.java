package com.spring.boot.mypack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.mypack.entity.Product;
import com.spring.boot.mypack.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public List<Product> getAllProducts(){
		
		return productRepository.getAllProducts();
	}
	
	public List<Product> getProductByName(String name){
		
		return productRepository.findByProductName(name);
	}
	
	
public List<Product> getProductById(String name){
		
		return productRepository.findByProductId(name);
	}
}
