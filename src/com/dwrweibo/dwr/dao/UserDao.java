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
	User findByName(String name);

	/**
	 * 根据用户名和密码查找用户
	 * 
	 * @param name
	 * @param pass
	 * @return 查找到的用户
	 */
	User findByNameAndPass(String name, String pass);
}
