package com.edexsoft.security;

import org.springframework.stereotype.Service;

import com.edexsoft.framework.security.User;
import com.edexsoft.framework.security.IUserService;

@Service("UserService")
public class UserService implements IUserService {
	
	public User findByAccount(String account){
		
		return new User();
		
	}
	
}
