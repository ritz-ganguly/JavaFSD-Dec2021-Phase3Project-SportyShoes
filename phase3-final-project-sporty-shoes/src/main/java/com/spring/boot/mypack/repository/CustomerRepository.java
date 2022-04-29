package com.spring.boot.mypack.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.spring.boot.mypack.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<User,String>{
	@Query(
			value ="select * from user u where u.type = '" + "customer" +"'",nativeQuery = true
			)
	List<User> getAllUsers();
	
	
	@Query(value ="select * from user u where u.type = '" + "customer" +"' "
			+ "and u.user_id = :userId",nativeQuery = true)
	User getUserDetails(String userId );
	
	
	

	
	
	
}
