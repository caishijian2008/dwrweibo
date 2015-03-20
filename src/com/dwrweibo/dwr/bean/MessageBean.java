package com.dwrweibo.dwr.bean;

public class MessageBean {

	// ��Ϣid
	private int id;
	// ��Ϣ����
	private String content;
	// ��Ϣ������id
	private int ownerId;
	// ��Ϣ����������
	private String ownerName;

	public MessageBean() {
	}

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
