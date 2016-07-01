package com.edexsoft.framework.security;

import java.util.List;

public interface UserService {
	User findById(Integer id);
//	User findByName(String name);
	User findByAccount(String account);
	List<User> findAll();
    void save(User entity);     
    void update(User entity);     
    void delete(Integer id); 
    void deleteAll();     
    public boolean isExist(User entity);
}
