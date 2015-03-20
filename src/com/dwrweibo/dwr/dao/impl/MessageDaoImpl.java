package com.dwrweibo.dwr.dao.impl;

import java.util.List;

import com.dwrweibo.dwr.common.impl.BaseDaoImpl;
import com.dwrweibo.dwr.dao.MessageDao;
import com.dwrweibo.dwr.entities.Message;

public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

	/**
	 * 查询指定页的信息
	 */
	@Override
	public List<Message> findAllByPage(int pageNo) {
		return findByPage("select m from Message m order by m.id desc", pageNo, PAGE_SIZE);
	}

}
