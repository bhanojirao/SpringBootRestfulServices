package com.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.model.User;
@Repository
public interface LoginRepository extends CrudRepository<User, Integer>{

	@Query("select  u from  user u where user_name=:uName And password=:uPassword")
	List<User> findByusernameAndUserPassword(String uName,String uPassword); 
}
