package com.spring.boot.mypack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.boot.mypack.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<User,String>{
	@Query(
			value ="select * from user u where u.type = '" + "admin" +"'",nativeQuery = true
			)
	List<User> getAllAdmins();
	
	
	
	
	
	@Query(
			value ="select * from user u where u.type = '" + "customer" +"'",nativeQuery = true
			)
	List<User> getAllUsers();
	
	
	
	@Query(
			value ="select * from user u where u.type = '" + "customer" +"' and"
					+ " name like %:name%",nativeQuery = true
			)
	List<User> getUsersByName(String name );
	
	
	
	
	@Query(
			value ="select * from user u where u.type = '" + "customer" +"' and"
					+ " user_id like %:userId%",nativeQuery = true
			)
	List<User> getUsersById(String userId );
}
