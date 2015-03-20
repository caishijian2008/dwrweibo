package com.dwrweibo.dwr.service;

import java.util.List;

import com.dwrweibo.dwr.bean.MessageBean;
import com.dwrweibo.dwr.entities.Message;
import com.dwrweibo.dwr.entities.User;

public interface MessageService {
	
	/**
	 * 创建一条微博
	 * @param message 新创建的微博
	 * @param userId 创建消息的用户id
	 * @return 新创建微博的主键，如果创建失败则返回-1
	 */
	int createMessage(Message message, int userId);
	
	/**
	 * 创建一个用户
	 * @param user 新创建的用户
	 * @return 新创建用户的主键
	 */
	int createUser(User user);
	
	/**
	 * 验证用户登录是否成功
	 * @param user 登录的用户
	 * @return 登录成功则返回用户id，否则返回-1
	 */
	int validateLogin(User user);
	
	/**
	 * 根据微博id返回微博
	 * @param msgId 微博id
	 * @return 指定id对应的微博
	 */
	MessageBean getMessage(int msgId);
	
	/**
	 * 返回指定页面的所有微博
	 * @param pageNo 页码
	 * @return 指定页面的所有微博
	 */
	public List<MessageBean> getAllMessageByPage(int pageNo);

}
