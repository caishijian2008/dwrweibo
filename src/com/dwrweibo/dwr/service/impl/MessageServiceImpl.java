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

	// ��ҵ���߼��������Ҫ������Dao���
	private UserDao userDao;
	private MessageDao messageDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	/**
	 * ����һ��΢��
	 * @param message �´�����΢��
	 * @param userId ������Ϣ���û�id
	 * 
	 * @return �´���΢�����������������ʧ���򷵻�-1
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
			throw new MessageException("���΢���쳣����");
		}
	}

	/**
	 * ����һ���û�
	 * @param user �´������û�
	 * @return �´����û�������
	 */
	@Override
	public int createUser(User user) {

		if (userDao.findByName(user.getUserName()) != null)
			throw new MessageException("���û����Ѿ����ڣ���");
		try {
			userDao.save(user);
			return user.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageException("ע���û������쳣����");
		}
	}

	/**
	 * ��֤�û���¼�Ƿ�ɹ�
	 * @param user ��¼���û�
	 * @return ��¼�ɹ��򷵻��û�id�����򷵻�-1
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
			throw new MessageException("��¼�����쳣����");
		}
		return -1;
	}

	/**
	 * ����΢��id����΢��
	 * @param msgId ΢��id
	 * @return ָ��id��Ӧ��΢��
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
			throw new MessageException("��ȡ΢�����ݳ����쳣����");
		}
		return null;
	}

	/**
	 * ����ָ��ҳ�������΢��
	 * @param pageNo ҳ��
	 * 
	 * @return ָ��ҳ�������΢��
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
			throw new MessageException("��ȡ΢���б��쳣����");
		}
		return null;
	}

}
