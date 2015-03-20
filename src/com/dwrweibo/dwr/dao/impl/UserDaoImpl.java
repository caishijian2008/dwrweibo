package com.dwrweibo.dwr.dao.impl;

import java.util.List;

import com.dwrweibo.dwr.common.impl.BaseDaoImpl;
import com.dwrweibo.dwr.dao.UserDao;
import com.dwrweibo.dwr.entities.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/**
	 * 根据用户名查找用户
	 */
	@Override
	public User findByName(String name) {
		
		List<User> ls = find("select u from User u where u.userName = ?0", name);
		if(ls != null && ls.size() > 0) {
			return ls.get(0);
		}
		
		return null;
	}

	/**
	 * 根据用户名和密码查找用户
	 */
	@Override
	public User findByNameAndPass(String name, String pass) {
		List ls = find("select u from User u where u.userName = ?0 and u.userPassword = ?1", name, pass);
		if(ls != null && ls.size() > 0) {
			return (User) ls.get(0);
		}
		return null;
	}

}
