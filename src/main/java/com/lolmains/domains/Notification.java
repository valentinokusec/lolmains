package com.lolmains.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;


	@JoinColumn(name = "fromuser")
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference
	private Summoner fromuser;
	
	@JoinColumn(name = "touser")
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference
	private Summoner touser;
	
	@JoinColumn(name = "content")
	private String Content;


	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Summoner getFromuser() {
		return fromuser;
	}

	public void setFromuser(Summoner fromuser) {
		this.fromuser = fromuser;
	}

	public Summoner getTouser() {
		return touser;
	}

	public void setTouser(Summoner touser) {
		this.touser = touser;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"fromuser\":" + fromuser + ", \"touser\":" + touser + ", \"content\":\"" + Content
				+ "\"}";
	}


	


}