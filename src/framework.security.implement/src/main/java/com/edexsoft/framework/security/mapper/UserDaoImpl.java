package com.edexsoft.framework.security.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.edexsoft.framework.security.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserMapper{
	
//	@Override
	public User findById(Integer id){
		return (User) getSqlSession().selectOne("com.edexsoft.framework.security.mapper.UserMapper.findById", id);
	}
	public User findByAccount(String account){
		return (User) getSqlSession().selectOne("com.edexsoft.framework.security.mapper.UserMapper.findByAccount", account);
	}
	public List<User> findAll(){
		return (List<User>) getSqlSession().<User>selectList("com.edexsoft.framework.security.mapper.UserMapper.findAll");
	}
	public void insert(User entity){
		getSqlSession().insert("com.edexsoft.framework.security.mapper.UserMapper.insert", entity);
	}
	public void update(User entity){
		getSqlSession().update("com.edexsoft.framework.security.mapper.UserMapper.update", entity);
	}
	public void delete(Integer id){
		getSqlSession().delete("com.edexsoft.framework.security.mapper.UserMapper.delete", id);
	}
	public void deleteAll(){
		getSqlSession().delete("com.edexsoft.framework.security.mapper.UserMapper.deleteAll");
	}
	public boolean isExist(User entity){
		return false;
	}
}
