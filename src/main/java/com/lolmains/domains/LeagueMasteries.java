package com.lolmains.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaguemasteries")
public class LeagueMasteries {
	
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="type")
	private int type;
	@Column(name="description")
	private String description;
	@Column(name="name")
	private String name;
	@Column(name="image")
	private String image;
	
	
	
	
	
	public LeagueMasteries() {
		super();
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}



	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LeagueMasteries(int type, long l, String description, String name, String image) {
		super();
		this.type = type;
		this.id = l;
		this.description = description;
		this.name = name;
		this.image = image;
	}

	
	
	
	
}
