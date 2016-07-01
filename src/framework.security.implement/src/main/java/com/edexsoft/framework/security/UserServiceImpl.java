package com.edexsoft.framework.security;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edexsoft.framework.security.mapper.UserMapper;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public User findById(Integer id){
		return this.userMapper.findById(id);
	}
	
	public User findByAccount(String account){
		return this.userMapper.findByAccount(account);
	}
	public List<User> findAll(){
		return this.userMapper.findAll();
	}
	public void save(User entity){
		this.userMapper.insert(entity);
	} 
	public void update(User entity){
		this.userMapper.update(entity);
	}
	public void delete(Integer id){
		this.userMapper.delete(id);
	}
	public void deleteAll(){
		this.userMapper.deleteAll();
	}
    public boolean isExist(User entity){
    	return false;
    }
	
}
