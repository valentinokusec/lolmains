package com.lolmains.domains;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="knowledge")
public class Knowledge {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public int id;
	@JoinColumn(name = "matchup")
	@ManyToOne
	public LeagueChampion matchup;
	@JoinColumn(name = "itemvs0")
	@ManyToOne
	public Item itemvs0;
	@JoinColumn(name = "itemvs1")
	@ManyToOne
	public Item itemvs1;
	@Column(name="url")
	public String url;
	@JoinColumn(name = "build")
	@ManyToMany
	private List<Item> build;
	
	@JoinColumn(name = "item")
	@ManyToOne
	private Item item;
	@JoinColumn(name = "main")
	@ManyToOne
	@JsonBackReference
	private Mains main;
	@Column(name="type")
	public int type;
	@Column(name="header")
	public String header;
	@Column(columnDefinition="VARCHAR(255)",name="content")
	public String content;
	@Column(name="date")
	public Timestamp date;
	@Column(name="video")
	public String video;
	@Column(name="votes")
	public int votes=0;
	@JoinColumn(name = "user")
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference
	private User user;
	@JoinColumn(name = "spells")
	@OneToMany(fetch=FetchType.EAGER)
	private List<ChampionSpells> spells;
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public LeagueChampion getMathup() {
		return matchup;
	}
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

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Item getItemvs0() {
		return itemvs0;
	}
	public void setItemvs0(Item itemvs0) {
		this.itemvs0 = itemvs0;
	}
	public Item getItemvs1() {
		return itemvs1;
	}
	public void setItemvs1(Item itemvs1) {
		this.itemvs1 = itemvs1;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	public void setMathup(LeagueChampion mathup) {
		this.matchup = mathup;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}

	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public Mains getMain() {
		return main;
	}
	public void setMain(Mains main) {
		this.main = main;
	}
	public LeagueChampion getMatchup() {
		return matchup;
	}
	public void setMatchup(LeagueChampion matchup) {
		this.matchup = matchup;
	}
	public List<ChampionSpells> getSpells() {
		return spells;
	}
	public void setSpells(List<ChampionSpells> spells) {
		this.spells = spells;
	}
	public List<Item> getBuild() {
		return build;
	}
	public void setBuild(List<Item> build) {
		this.build = build;
	}

	
	
}
