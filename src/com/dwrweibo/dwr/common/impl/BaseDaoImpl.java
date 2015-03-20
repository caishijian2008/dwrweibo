package com.dwrweibo.dwr.common.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.dwrweibo.dwr.common.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	//Dao组件进行持久化操作底层依赖的SessionFactory组件
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 保存实体
	 */
	@Override
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	@Override
	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		delete(get(entityClazz, id));
	}

	//获取所有实体
	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	//获取实体总数
	@Override
	public long findCount(Class<T> entityClazz) {
		List ls = find("select count(*) from " + entityClazz.getSimpleName());
		//查询得到的实体总数
		if(ls != null && ls.size() == 1) {
			return (long) ls.get(0);
		}
		return 0;
	}
	
	//根据hql语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return (List<T>)getSessionFactory().getCurrentSession().createQuery(hql).list();
	}
	
	/**
	 * 根据带占位符参数的hql语句查询实体
	 * @param hql hql语句
	 * @param params 用于传入占位符参数
	 * @return 查询实体
	 */
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		//创建查询
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		//为包含占位符的hql语句设置参数
		for(int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>)query.list();
	}
	
	/**
	 * 使用hql语句进行分页查询
	 * @param hql hql语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页要显示的页数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		//执行查询
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		//执行分页并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	/**
	 * 使用hql语句进行分页查询
	 * @param hql hql语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页要显示的页数
	 * @param params 用于传入占位符参数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		//执行查询
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		//为包含占位符的hql语句设置参数
		for(int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		//执行分页并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}

}
