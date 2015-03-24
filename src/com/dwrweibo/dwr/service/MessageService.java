package com.dwrweibo.dwr.service;

import java.util.List;

import com.dwrweibo.dwr.bean.MessageBean;
import com.dwrweibo.dwr.entities.Message;
import com.dwrweibo.dwr.entities.User;

public interface MessageService {
	
	/**
	 * ����һ��΢��
	 * @param message �´�����΢��
	 * @param userId ������Ϣ���û�id
	 * @return �´���΢�����������������ʧ���򷵻�-1
	 */
	public int createMessage(Message message, int userId);
	
	/**
	 * ����һ���û�
	 * @param user �´������û�
	 * @return �´����û�������
	 */
	public int createUser(User user);
	
	/**
	 * ��֤�û���¼�Ƿ�ɹ�
	 * @param user ��¼���û�
	 * @return ��¼�ɹ��򷵻��û�id�����򷵻�-1
	 */
	public int validateLogin(User user);
	
	/**
	 * ����΢��id����΢��
	 * @param msgId ΢��id
	 * @return ָ��id��Ӧ��΢��
	 */
	public MessageBean getMessage(int msgId);
	
	/**
	 * ����ָ��ҳ�������΢��
	 * @param pageNo ҳ��
	 * @return ָ��ҳ�������΢��
	 */
	public List<MessageBean> getAllMessageByPage(int pageNo);

}
