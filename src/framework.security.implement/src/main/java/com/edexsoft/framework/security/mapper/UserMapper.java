package com.edexsoft.framework.security.mapper;

import java.util.List;

import com.edexsoft.framework.security.User;

public interface UserMapper {
	User findById(Integer id);
	User findByAccount(String account);
	List<User> findAll();
	void insert(User entity);
	void update(User entity);
	void delete(Integer id);
	void deleteAll();
	boolean isExist(User entity);
}
