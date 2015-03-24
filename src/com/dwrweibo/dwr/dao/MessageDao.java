package com.dwrweibo.dwr.dao;

import java.util.List;

import com.dwrweibo.dwr.common.BaseDao;
import com.dwrweibo.dwr.entities.Message;

public interface MessageDao extends BaseDao<Message>{

	// 每页显示的记录条数
	public static final int PAGE_SIZE = 10;

	/**
	 * 根据指定页查询消息
	 * @param pageNo
	 * @return 查询到的消息集合
	 */
	public List<Message> findAllByPage(int pageNo);
}
