package com.lolmains.domains;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="video")
public class Video {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public int id;
	@JoinColumn(name = "main")
	@ManyToOne
	public Mains main;
	@Column(name="likes")
	public int likes=0;
	@Column(name="type")
	public int type;
	@Column(name="header")
	public String header;
	@Column(name="content")
	public String content;
	@Column(name="featured")
	public boolean featured;
	@Column(name="url")
	public String url;
	@JoinColumn(name = "user")
	@ManyToOne
	public Summoner user;
	@Column(name="date")
	public Timestamp date;
	

	
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public Mains getMain() {
		return main;
	}
	public void setMain(Mains main) {
		this.main = main;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Summoner getUser() {
		return user;
	}
	public void setUser(Summoner user) {
		this.user = user;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}


	
}
