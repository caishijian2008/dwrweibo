package com.dwrweibo.dwr.entities;

public class Message {

	private Integer id;
	private String contents;
	private User user;
	
	public Message() {
	}

	public Message(Integer id, String contents, User user) {
		super();
		this.id = id;
		this.contents = contents;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
