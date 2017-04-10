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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="league_champion")
public class LeagueChampion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="champion_detail_id")
	private Long championid;
	@Column(name="image")
	private String image;
	@Column(name="name")
	private String name;
	@Column(name="type")
	private int type;
	@JoinColumn(name = "spells")
	@OneToMany(fetch=FetchType.EAGER)
	private List<ChampionSpells> spells;
	
	
	
	
	

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
	public Long getChampion_detail_id() {
		return championid;
	}
	public void setChampion_detail_id(Long champion_detail_id) {
		this.championid = champion_detail_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Long getChampionid() {
		return championid;
	}
	public void setChampionid(Long championid) {
		this.championid = championid;
	}
	public List<ChampionSpells> getSpells() {
		return spells;
	}
	public void setSpells(List<ChampionSpells> spells) {
		this.spells = spells;
	}

	
	
	

}
