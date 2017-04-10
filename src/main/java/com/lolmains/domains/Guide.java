package com.lolmains.domains;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="guide")
public class Guide {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(columnDefinition="text",name="content")
	private String content;
	@Column(name="date")
	private Timestamp date;
	@JoinColumn(name = "buildid")
	@OneToOne
	private Build build;
	@JoinColumn(name = "runesid")
	@OneToOne
	private Runes runes;
	@JoinColumn(name = "masteriesid")
	@OneToOne
	private Masteries masteriesid;
	@JoinColumn(name = "summonersid")
	@OneToOne
	private Summoners summoners;
	@JoinColumn(name = "user")
	@OneToOne
	private Summoner user;
	@JoinColumn(name = "main")
	@OneToOne
	private Mains main;
	
	
	
	
	public Guide() {
		super();
	}
	public Guide(String name, String content, Summoner user, Timestamp date) {
		super();
		this.name = name;
		this.content = content;
		this.user = user;
		this.date = date;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Summoner getUser() {
		return user;
	}
	public void setUser(Summoner user) {
		this.user = user;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Build getBuild() {
		return build;
	}
	public void setBuild(Build build) {
		this.build = build;
	}
	public Runes getRunes() {
		return runes;
	}
	public void setRunes(Runes runes) {
		this.runes = runes;
	}
	public Masteries getMasteriesid() {
		return masteriesid;
	}
	public void setMasteriesid(Masteries masteriesid) {
		this.masteriesid = masteriesid;
	}
	public Summoners getSummoners() {
		return summoners;
	}
	public void setSummoners(Summoners summoners) {
		this.summoners = summoners;
	}
	public Mains getMain() {
		return main;
	}
	public void setMain(Mains main) {
		this.main = main;
	}
	
}
