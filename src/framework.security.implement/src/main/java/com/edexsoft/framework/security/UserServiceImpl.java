package com.edexsoft.framework.security;

import org.springframework.transaction.annotation.Transactional;

import com.edexsoft.framework.security.mapper.UserMapper;

@Transactional
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User Get(Integer userId) {
		return this.userMapper.getUser(userId);
	}
}
