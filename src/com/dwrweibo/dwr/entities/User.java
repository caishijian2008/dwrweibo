package com.dwrweibo.dwr.entities;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer id;
	//ÓÃ»§Ãû
	private String userName;
	//ÃÜÂë
	private String userPassword;
	//ÓÊÏä
	private String userEmail;
	private Set<Message> messages = new HashSet<>();
	
	public User() {
	}

	public User(Integer id, String userName, String userPassword,
			String userEmail, Set<Message> messages) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
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

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	
}
