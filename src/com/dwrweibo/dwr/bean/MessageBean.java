package com.dwrweibo.dwr.bean;

public class MessageBean {

	// 微博id
	private int id;
	// 微博内容
	private String content;
	// 微博发布者id
	private int ownerId;
	// 微博发布者名字
	private String ownerName;

	public MessageBean() {
	}

	/**
	 * MessageBean 构造函数
	 * 
	 * @param id 微博id
	 * @param content 微博内容
	 * @param ownerId 微博发布者id
	 * @param ownerName 微博发布者名字
	 */
	public MessageBean(int id, String content, int ownerId, String ownerName) {
		super();
		this.id = id;
		this.content = content;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
