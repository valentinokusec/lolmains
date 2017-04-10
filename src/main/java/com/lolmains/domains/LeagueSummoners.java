package com.lolmains.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaguesummoners")
public class LeagueSummoners {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="type")
	private int type;
	@Column(name="summonersid")
	private Long summonersid;
	@Column(name="description")
	private String description;
	@Column(name="name")
	private String name;
	@Column(name="image")
	private String image;
	
	
	
	
	
	public LeagueSummoners() {
		super();
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getSummonersid() {
		return summonersid;
	}
	public void setSummonersid(Long summonersid) {
		this.summonersid = summonersid;
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
	public LeagueSummoners(int type, Long summonersid, String description, String name, String image) {
		super();
		this.type = type;
		this.summonersid = summonersid;
		this.description = description;
		this.name = name;
		this.image = image;
	}

	
	
	
	
}
