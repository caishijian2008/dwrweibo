package com.dwrweibo.dwr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dwrweibo.dwr.bean.MessageBean;
import com.dwrweibo.dwr.dao.MessageDao;
import com.dwrweibo.dwr.dao.UserDao;
import com.dwrweibo.dwr.entities.Message;
import com.dwrweibo.dwr.entities.User;
import com.dwrweibo.dwr.exception.MessageException;
import com.dwrweibo.dwr.service.MessageService;

public class MessageServiceImpl implements MessageService {

	// 该业务逻辑组件所需要的两个Dao组件
	private UserDao userDao;
	private MessageDao messageDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	/**
	 * 创建一条微博
	 * @param message 新创建的微博
	 * @param userId 创建消息的用户id
	 * 
	 * @return 新创建微博的主键，如果创建失败则返回-1
	 */
	@Override
	public int createMessage(Message message, int userId) {

		try {
			User user = userDao.get(User.class, userId);
			if (user != null) {
				message.setUser(user);
				return (Integer) messageDao.save(message);
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageException("添加微博异常！！");
		}
	}

	/**
	 * 创建一个用户
	 * @param user 新创建的用户
	 * @return 新创建用户的主键
	 */
	@Override
	public int createUser(User user) {

		if (userDao.findByName(user.getUserName()) != null)
			throw new MessageException("该用户名已经存在！！");
		try {
			userDao.save(user);
			return user.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageException("注册用户出现异常！！");
		}
	}

	/**
	 * 验证用户登录是否成功
	 * @param user 登录的用户
	 * @return 登录成功则返回用户id，否则返回-1
	 */
	@Override
	public int validateLogin(User user) {
		try {
			User u = userDao.findByNameAndPass(user.getUserName(), user.getUserPassword());
			if(u != null) {
				return u.getId();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageException("登录出现异常！！");
		}
		return -1;
	}

	/**
	 * 根据微博id返回微博
	 * @param msgId 微博id
	 * @return 指定id对应的微博
	 */
	@Override
	public MessageBean getMessage(int msgId) {
		try {
			Message message = messageDao.get(Message.class, msgId);
			if(message != null) {
				return new MessageBean(0, message.getContents(), message.getUser().getId(), message.getUser().getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageException("获取微博内容出现异常！！");
		}
		return null;
	}

	/**
	 * 返回指定页面的所有微博
	 * @param pageNo 页码
	 * 
	 * @return 指定页面的所有微博
	 */
	@Override
	public List<MessageBean> getAllMessageByPage(int pageNo) {
		try {
			List<Message> ls = messageDao.findAllByPage(pageNo);
			if(ls != null && ls.size() > 0) {
				List<MessageBean> result = new ArrayList<>();
				for(Message msg : ls) {
					result.add(new MessageBean(msg.getId(), null, 0, msg.getUser().getUserName()));
				}
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageException("获取微博列表异常！！");
		}
		return null;
	}

}
