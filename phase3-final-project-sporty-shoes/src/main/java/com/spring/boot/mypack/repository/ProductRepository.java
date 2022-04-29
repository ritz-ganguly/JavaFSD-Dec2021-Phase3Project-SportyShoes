package com.spring.boot.mypack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.boot.mypack.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	@Query(value ="select * from product p",nativeQuery = true)
	List<Product> getAllProducts();
	

	@Query(value = "select * from product p where p.product_name like %:name%",nativeQuery=true)
	List<Product> findByProductName(String name);
	
	@Query(value = "select * from product p where p.product_number like %:id%",nativeQuery=true)
	List<Product> findByProductId(String id);
	
	
}
