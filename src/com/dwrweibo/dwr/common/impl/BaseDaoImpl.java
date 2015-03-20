package com.dwrweibo.dwr.common.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.dwrweibo.dwr.common.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	//Dao������г־û������ײ�������SessionFactory���
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * ����ʵ��
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

	//��ȡ����ʵ��
	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	//��ȡʵ������
	@Override
	public long findCount(Class<T> entityClazz) {
		List ls = find("select count(*) from " + entityClazz.getSimpleName());
		//��ѯ�õ���ʵ������
		if(ls != null && ls.size() == 1) {
			return (long) ls.get(0);
		}
		return 0;
	}
	
	//����hql����ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return (List<T>)getSessionFactory().getCurrentSession().createQuery(hql).list();
	}
	
	/**
	 * ���ݴ�ռλ��������hql����ѯʵ��
	 * @param hql hql���
	 * @param params ���ڴ���ռλ������
	 * @return ��ѯʵ��
	 */
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		//������ѯ
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		//Ϊ����ռλ����hql������ò���
		for(int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>)query.list();
	}
	
	/**
	 * ʹ��hql�����з�ҳ��ѯ
	 * @param hql hql���
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳҪ��ʾ��ҳ��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		//ִ�в�ѯ
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		//ִ�з�ҳ�����ز�ѯ���
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	/**
	 * ʹ��hql�����з�ҳ��ѯ
	 * @param hql hql���
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳҪ��ʾ��ҳ��
	 * @param params ���ڴ���ռλ������
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		//ִ�в�ѯ
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		//Ϊ����ռλ����hql������ò���
		for(int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		//ִ�з�ҳ�����ز�ѯ���
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}

}
