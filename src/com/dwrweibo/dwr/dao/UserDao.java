package com.dwrweibo.dwr.dao;

import com.dwrweibo.dwr.common.BaseDao;
import com.dwrweibo.dwr.entities.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * �����û��������û�
	 * 
	 * @param name
	 * @return ���ҵ����û�
	 */
	User findByName(String name);

	/**
	 * �����û�������������û�
	 * 
	 * @param name
	 * @param pass
	 * @return ���ҵ����û�
	 */
	User findByNameAndPass(String name, String pass);
}
