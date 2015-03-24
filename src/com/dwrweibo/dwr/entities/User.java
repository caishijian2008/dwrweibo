package com.dwrweibo.dwr.entities;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer id;
	//用户名
	private String userName;
	//密码
	private String userPassword;
	//邮箱
	private String userEmail;
	//级别：管理员为0，普通用户为1
	private String userLevel;
	
	private Set<Message> messages = new HashSet<>();
	
	public User() {
	}

	public User(Integer id, String userName, String userPassword,
			String userLevel, Set<Message> messages) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userLevel = userLevel;
		this.messages = messages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	
}
