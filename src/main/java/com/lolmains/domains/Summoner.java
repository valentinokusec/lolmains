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
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="summoner")
public class Summoner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="verified")
	private boolean verified;
	@Column(name="summonerid")
	private Long summonerid;
	@Column(name="userid")
	private Long userId;
	@Column(name="name")
	private String name;
	@Column(name="image")
	private int image;
	@Column(name="winrate")
	private Double winrate;
	@Column(name="kills")
	private Double kills;
	@Column(name="deaths")
	private Double deaths;
	@Column(name="assists")
	private Double assists;
	@Column(name="games")
	private int games;
	@Column(name="region")
	private String region;
	@Column(name="tierNumber")
	private int tierNumber;
	@Column(name="tier")
	private String tier;
	@JoinColumn(name = "champion")
	@OneToMany(fetch=FetchType.EAGER)
	private List<Champion> champion;
	@JoinColumn(name = "guide")
	@OneToMany
	@JsonIgnore
	private List<Guide> guide;
	@JoinColumn(name = "main")
	@OneToMany
	@JsonIgnore
	private List<Mains> main;
	@JoinColumn(name = "notification")
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Notification> notification;
	@Column(name="notificationcount")
	private int notificationcount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getSummonerid() {
		return summonerid;
	}
	public void setSummonerid(Long summonerid) {
		this.summonerid = summonerid;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getKills() {
		return kills;
	}
	public void setKills(Double kills) {
		this.kills = kills;
	}
	public Double getDeaths() {
		return deaths;
	}
	public void setDeaths(Double deaths) {
		this.deaths = deaths;
	}
	public Double getAssists() {
		return assists;
	}
	public void setAssists(Double assists) {
		this.assists = assists;
	}
	public int getGames() {
		return games;
	}
	public void setGames(int games) {
		this.games = games;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public List<Champion> getChampion() {
		return champion;
	}
	public void setChampion(List<Champion> champion) {
		this.champion = champion;
	}
	public Double getWinrate() {
		return winrate;
	}
	public void setWinrate(Double winrate) {
		this.winrate = winrate;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int i) {
		this.image = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTierNumber() {
		return tierNumber;
	}
	public void setTierNumber(int tierNumber) {
		this.tierNumber = tierNumber;
	}
	public List<Guide> getGuide() {
		return guide;
	}
	public void setGuide(List<Guide> guide) {
		this.guide = guide;
	}
	public List<Mains> getMain() {
		return main;
	}
	public void setMain(List<Mains> main) {
		this.main = main;
	}
	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"image\":"+image+",\"name\":\""+name+"\"}";
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}
	public int getNotificationcount() {
		return notificationcount;
	}
	public void setNotificationcount(int notificationcount) {
		this.notificationcount = notificationcount;
	}
	
	

}
