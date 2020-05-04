package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.User;

public interface UserDao {

	User findByName(String name);

	List<User> findByLastName(String lastName);
	
	List<User> findAll();

	List<User> findLetterAll(String letter);

}