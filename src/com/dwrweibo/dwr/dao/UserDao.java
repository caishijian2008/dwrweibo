package com.dwrweibo.dwr.dao;

import com.dwrweibo.dwr.common.BaseDao;
import com.dwrweibo.dwr.entities.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 根据用户名查找用户
	 * 
	 * @param name
	 * @return 查找到的用户
	 */
	public User findByName(String name);

	/**
	 * 根据用户名,密码和级别查找用户
	 * 
	 * @param name
	 * @param pass
	 * @param level
	 * @return 查找到的用户
	 */
	public User findByNameAndPass(String name, String pass, String level);
}
