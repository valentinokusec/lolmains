package com.lolmains.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mains")
public class Mains {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="banner")
	private String banner;
	@JoinColumn(name = "champion")
	@ManyToOne
	private LeagueChampion champion;
	@JoinColumn(name = "mainspropertiess")
	@OneToOne
	private MainsProperties mainsproperties;
	@JoinColumn(name = "bestof")
	@OneToOne
	private BestOf bestof;
	@JoinColumn(name = "guide")
	@OneToMany
	private List<Guide> guide;
	@JoinColumn(name = "admins")
	@ManyToMany
	private List<User> admins;
	@JoinColumn(name = "video")
	@OneToMany
	private List<Video> video;
	@JoinColumn(name = "summoner")
	@ManyToMany
	private List<Summoner> summoner;
	@JoinColumn(name = "discussion")
	@OneToMany
	private List<Discussion> discussion;
	@JoinColumn(name = "knowledge")
	@OneToMany
	private List<Knowledge> knowledge;
	@JoinColumn(name = "knowledge")
	@OneToMany
	private List<MailingList> mailingList;
	
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
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public BestOf getBestof() {
		return bestof;
	}
	public void setBestof(BestOf guide2) {
		this.bestof = guide2;
	}
	public List<Guide> getGuide() {
		return guide;
	}
	public void setGuide(List<Guide> guide) {
		this.guide = guide;
	}
	public LeagueChampion getChampion() {
		return champion;
	}
	public void setChampion(LeagueChampion leagueChampion) {
		this.champion = leagueChampion;
	}
	public List<User> getAdmins() {
		return admins;
	}
	public void setAdmins(List<User> admins) {
		this.admins = admins;
	}
	public List<Video> getVideo() {
		return video;
	}
	public void setVideo(List<Video> video) {
		this.video = video;
	}
	public List<Summoner> getSummoner() {
		return summoner;
	}
	public void setSummoner(List<Summoner> summoner) {
		this.summoner = summoner;
	}
	public List<Discussion> getDiscussion() {
		return discussion;
	}
	public void setDiscussion(List<Discussion> discussion) {
		this.discussion = discussion;
	}
	public MainsProperties getMainsproperties() {
		return mainsproperties;
	}
	public void setMainsproperties(MainsProperties mainsproperties) {
		this.mainsproperties = mainsproperties;
	}
	public List<Knowledge> getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(List<Knowledge> knowledge) {
		this.knowledge = knowledge;
	}
	public List<MailingList> getMailingList() {
		return mailingList;
	}
	public void setMailingList(List<MailingList> mailingList) {
		this.mailingList = mailingList;
	}
	
}
