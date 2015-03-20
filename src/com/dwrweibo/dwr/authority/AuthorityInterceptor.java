package com.dwrweibo.dwr.authority;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;

import com.dwrweibo.dwr.exception.MessageException;

public class AuthorityInterceptor {
	
	public void authority(JoinPoint jp) {
		
		HttpSession session = null;
		//��ȡ�����ط�����ȫ������
		Object[] args = jp.getArgs();
		//���������ط�����ȫ������
		for(int i = 0; i < args.length; i++) {
			//�ҵ�HttpSession���͵Ĳ���
			if(args[i] instanceof HttpSession)
				session = (HttpSession) args[i];
			//ȡ��HttpSession���user����
			Integer userId = (Integer) session.getAttribute("userId");
			if(userId == null || userId <= 0) {
				throw new MessageException("����û��½�����ȵ�¼ϵͳ����ִ�в�������");
			}
		}
	}

}
