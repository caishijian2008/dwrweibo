package com.dwrweibo.dwr.common;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	//保存实体
	Serializable save(T entity);
	//根据id获取实体
	T get(Class<T> entityClazz, Serializable id);
	//更新实体
	void update(T entity);
	//删除实体
	void delete(T entity);
	//根据id删除实体
	void delete(Class<T> entityClazz, Serializable id);
	//查找所有实体
	List<T> findAll(Class<T> entityClazz);
	//获取实体的总数
	long findCount(Class<T> entityClazz);
}
