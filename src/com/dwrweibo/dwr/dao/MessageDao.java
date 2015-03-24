package com.dwrweibo.dwr.dao;

import java.util.List;

import com.dwrweibo.dwr.common.BaseDao;
import com.dwrweibo.dwr.entities.Message;

public interface MessageDao extends BaseDao<Message>{

	// ÿҳ��ʾ�ļ�¼����
	public static final int PAGE_SIZE = 10;

	/**
	 * ����ָ��ҳ��ѯ��Ϣ
	 * @param pageNo
	 * @return ��ѯ������Ϣ����
	 */
	public List<Message> findAllByPage(int pageNo);
}
