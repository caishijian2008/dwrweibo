package com.dwrweibo.dwr.common;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	//����ʵ��
	Serializable save(T entity);
	//����id��ȡʵ��
	T get(Class<T> entityClazz, Serializable id);
	//����ʵ��
	void update(T entity);
	//ɾ��ʵ��
	void delete(T entity);
	//����idɾ��ʵ��
	void delete(Class<T> entityClazz, Serializable id);
	//��������ʵ��
	List<T> findAll(Class<T> entityClazz);
	//��ȡʵ�������
	long findCount(Class<T> entityClazz);
}
