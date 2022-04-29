package com.spring.boot.mypack.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.boot.mypack.entity.Order;
import com.spring.boot.mypack.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
	@Query(value = "select * from orders o where o.user_id= :userId",nativeQuery=true)
	List<Order> userPurchaseHistory(String userId);
	
	
	
	@Query(value = "select * from orders o where o.product_id= :productId",nativeQuery=true)
	List<Order> getOrdersByProductId(int productId);
	
	
	
	@Query(value = "select * from orders o where o.user_id like %:userId%",nativeQuery=true)
	List<Order> getOrdersByUserId(String userId);
	
	
	@Query(value = "select * from orders o order by o.order_date",nativeQuery=true)
	List<Order> sortByOrderDateAsc();
	
	
	@Query(value = "select * from orders o order by o.order_date desc",nativeQuery=true)
	List<Order> sortByOrderDateDesc();
	
	
	@Query(value = "select * from orders o order by o.order_id",nativeQuery=true)
	List<Order> sortByOrderIdAsc();
	
	
	
	@Query(value = "select * from orders o order by o.order_id desc",nativeQuery=true)
	List<Order> sortByOrderIdDesc();
	
	
	
	

    

}
