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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="discussion")
public class Discussion {
	
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
	@JoinColumn(name = "item1id")
	@ManyToOne
	private Item item1id;
	@JoinColumn(name = "item2id")
	@ManyToOne
	private Item item2id;
	@JoinColumn(name = "item3id")
	@ManyToOne
	private Item item3id;
	@JoinColumn(name = "item4id")
	@ManyToOne
	private Item item4id;
	@JoinColumn(name = "item5id")
	@ManyToOne
	private Item item5id;
	@JoinColumn(name = "item6id")
	@ManyToOne
	private Item item6id;
	
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
	@Column(length = 100000,name="content")
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
	public Item getItem1id() {
		return item1id;
	}
	public void setItem1id(Item item1id) {
		this.item1id = item1id;
	}
	public Item getItem2id() {
		return item2id;
	}
	public void setItem2id(Item item2id) {
		this.item2id = item2id;
	}
	public Item getItem3id() {
		return item3id;
	}
	public void setItem3id(Item item3id) {
		this.item3id = item3id;
	}

	public Item getItem5id() {
		return item5id;
	}
	public void setItem5id(Item item5id) {
		this.item5id = item5id;
	}
	public Item getItem6id() {
		return item6id;
	}
	public void setItem6id(Item item6id) {
		this.item6id = item6id;
	}
	public Item getItem4id() {
		return item4id;
	}
	public void setItem4id(Item item4id) {
		this.item4id = item4id;
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

	
	
}
