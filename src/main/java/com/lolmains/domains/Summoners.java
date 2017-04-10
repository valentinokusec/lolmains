package com.lolmains.domains;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="summoners")
public class Summoners {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(columnDefinition="text",name="description")
	private String description;

	@JoinColumn(name = "summoner1id")
	@ManyToOne
	private LeagueSummoners summoner1;
	
	@JoinColumn(name = "summoner2id")
	@ManyToOne
	private LeagueSummoners summoner2;
	
	
	
	public Summoners() {
		super();
	}
	public Summoners(String description, LeagueSummoners summoner1, LeagueSummoners summoner2) {
		super();
		this.description = description;
		this.summoner1 = summoner1;
		this.summoner2 = summoner2;
	}
	public void setSummoner1(LeagueSummoners summoner1) {
		this.summoner1 = summoner1;
	}
	public void setSummoner2(LeagueSummoners summoner2) {
		this.summoner2 = summoner2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LeagueSummoners getSummoner1() {
		return summoner1;
	}
	public LeagueSummoners getSummoner2() {
		return summoner2;
	}


	
	
	
	
	
}
