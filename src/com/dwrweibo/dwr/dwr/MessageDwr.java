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
	
	//����һ��΢��
	public int createMessage(String content, HttpSession session) throws MessageException{
		Integer userId = (Integer) session.getAttribute("userId");
		Message message = new Message();
		message.setContents(content);
		return messageService.createMessage(message, userId);
	}
	
	//����һ���û�
	public int createUser(String username, String password, String email, HttpSession session) throws MessageException {
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(password);
		user.setUserEmail(email);
		int userId = messageService.createUser(user);
		session.setAttribute("userId", userId);
		return userId;
	}
	
	//��֤�û�
	public int validUser(String username, String password, HttpSession session) throws MessageException {
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(password);
		int userId = messageService.validateLogin(user);
		if(userId > 0) {
			session.setAttribute("userId", userId);
		}
		return userId;
	}
	
	//�жϵ�ǰҳ���������Ƿ��Ѿ���¼
	public int isLogin(HttpSession session) throws MessageException {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId != null && userId > 0) {
			return (Integer)userId;
		}
		return -1;
	}
	
	//����΢��id����΢��
	public MessageBean getMessage(int msgId, HttpSession session) throws MessageException {
		return messageService.getMessage(msgId);
	}
	
	//����ָ��ҳ����ʾ��ȫ��΢��
	public List<MessageBean> getAllMessageByPage(int pageNo, HttpSession session) throws MessageException {
		return messageService.getAllMessageByPage(pageNo);
	}

}
