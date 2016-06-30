package com.edexsoft.framework.security.mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.edexsoft.framework.security.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserMapper{
	@Override
	public User getUser(Integer userId) {
		return (User) getSqlSession().selectOne("org.mybatis.spring.sample.mapper.UserMapper.getUser", userId);
	}
}
