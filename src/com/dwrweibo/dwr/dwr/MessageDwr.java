package com.dwrweibo.dwr.dwr;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.dwrweibo.dwr.bean.MessageBean;
import com.dwrweibo.dwr.entities.Message;
import com.dwrweibo.dwr.entities.User;
import com.dwrweibo.dwr.exception.MessageException;
import com.dwrweibo.dwr.service.MessageService;

public class MessageDwr {

	private MessageService messageService;

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	//创建一条微博
	public int createMessage(String content, HttpSession session) throws MessageException{
		Integer userId = (Integer) session.getAttribute("userId");
		Message message = new Message();
		message.setContents(content);
		return messageService.createMessage(message, userId);
	}
	
	//创建一个用户
	public int createUser(String username, String password, String email, String level, HttpSession session) throws MessageException {
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(password);
		user.setUserEmail(email);
		user.setUserLevel(level);
		int userId = messageService.createUser(user);
		session.setAttribute("userId", userId);
		return userId;
	}
	
	//验证用户
	public int validUser(String username, String password, String level, HttpSession session) throws MessageException {
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(password);
		user.setUserLevel(level);
		int userId = messageService.validateLogin(user);
		if(userId > 0) {
			session.setAttribute("userId", userId);
		}
		return userId;
	}
	
	//判断当前页面的浏览者是否已经登录
	public int isLogin(HttpSession session) throws MessageException {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId != null && userId > 0) {
			return (Integer)userId;
		}
		return -1;
	}
	
	//根据微博id返回微博
	public MessageBean getMessage(int msgId, HttpSession session) throws MessageException {
		return messageService.getMessage(msgId);
	}
	
	//返回指定页所显示的全部微博
	public List<MessageBean> getAllMessageByPage(int pageNo, HttpSession session) throws MessageException {
		return messageService.getAllMessageByPage(pageNo);
	}

}
