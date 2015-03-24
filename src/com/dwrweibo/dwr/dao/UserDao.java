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
	public User findByName(String name);

	/**
	 * �����û���,����ͼ�������û�
	 * 
	 * @param name
	 * @param pass
	 * @param level
	 * @return ���ҵ����û�
	 */
	public User findByNameAndPass(String name, String pass, String level);
}
