package com.lolmains.domains;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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

@Entity
@Table(name="champion")
public class Champion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="summoner")
	private String summoner;
	@Column(name="name")
	private String name;
	@Column(name="kills")
	private Double kills;
	@Column(name="deaths")
	private Double deaths;
	@Column(name="assists")
	private Double assists;
	@Column(name="winrate")
	private Double winrate;
	@JoinColumn(name = "leaguechampion")
	@ManyToOne
	private LeagueChampion leaguechampion;
	@Column(name="games")
	private int games;
	@Column(name="champion_points")
	private long championPoints;
	@Column(name="tier")
	private String tier;
	
	
	
	
	

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getSummoner() {
		return summoner;
	}
	public void setSummoner(String summoner) {
		this.summoner = summoner;
	}
	public Double getWinrate() {
		return winrate;
	}
	public void setWinrate(Double winrate) {
		this.winrate = winrate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getChampionPoints() {
		return championPoints;
	}
	public void setChampionPoints(long l) {
		this.championPoints = l;
	}
	public LeagueChampion getLeaguechampion() {
		return leaguechampion;
	}
	public void setLeaguechampion(LeagueChampion leaguechampion) {
		this.leaguechampion = leaguechampion;
	}


	
	
	
	

}
