package com.dwrweibo.dwr.authority;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;

import com.dwrweibo.dwr.exception.MessageException;

public class AuthorityInterceptor {
	
	public void authority(JoinPoint jp) {
		
		HttpSession session = null;
		//获取被拦截方法的全部参数
		Object[] args = jp.getArgs();
		//遍历被拦截方法的全部参数
		for(int i = 0; i < args.length; i++) {
			//找到HttpSession类型的参数
			if(args[i] instanceof HttpSession)
				session = (HttpSession) args[i];
			//取出HttpSession里的user属性
			Integer userId = (Integer) session.getAttribute("userId");
			if(userId == null || userId <= 0) {
				throw new MessageException("您还没登陆，请先登录系统后再执行操作！！");
			}
		}
	}

}
