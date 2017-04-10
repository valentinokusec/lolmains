package com.lolmains.forms;

public class Greeting {

	private String content;
	private int id;
	private int userid;
	private int image;
	private String username;
	private boolean type;
	private int commentId;
	private int notificationcounter;
	private String notification;
	public Greeting() {
	}

	public Greeting(String content, int id, boolean type, int commentId, int userid, int image, String username,int notificationcounter,String notification) {
		super();
		this.content = content;
		this.id = id;
		this.userid = userid;
		this.image = image;
		this.username = username;
		this.type = type;
		this.commentId = commentId;
		this.notificationcounter = notificationcounter;
		this.notification = notification;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getNotificationcounter() {
		return notificationcounter;
	}

	public void setNotificationcounter(int notificationcounter) {
		this.notificationcounter = notificationcounter;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

}