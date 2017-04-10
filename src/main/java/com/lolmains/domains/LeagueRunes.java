package com.lolmains.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="league_runes")
public class LeagueRunes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="type")
	private int type;
	@Column(name="runeid")
	private int runeid;
	@Column(name="depth")
	private int depth;
	@Column(name="description")
	private String description;
	@Column(name="name")
	private String name;
	@Column(name="image")
	private String image;
	
	
	
	
	
	public LeagueRunes() {
		super();
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
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
	public int getRuneid() {
		return runeid;
	}
	public void setRuneid(int runeid) {
		this.runeid = runeid;
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
	public LeagueRunes(int i,int type, String description, String name,String image, int depth) {
		super();
		this.runeid = i;
		this.description = description;
		this.name = name;
		this.image = image;
		this.depth = depth;
		this.type = type;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	
	
	
	
}
