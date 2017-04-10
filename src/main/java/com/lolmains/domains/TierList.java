package com.lolmains.domains;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="build")
public class TierList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@JoinColumn(name = "main")
	@ManyToOne
	@JsonBackReference
	private Mains main;

	@JoinColumn(name = "tiera")
	@ManyToMany
	private List<LeagueChampion> tiera;
	
	@JoinColumn(name = "tierb")
	@ManyToMany
	private List<LeagueChampion> tierb;
	
	@JoinColumn(name = "tierc")
	@ManyToMany
	private List<LeagueChampion> tierc;
	
	@JoinColumn(name = "tierd")
	@ManyToMany
	private List<LeagueChampion> tierd;
	
	
	
	
	
	
	public TierList() {
		super();
	}






	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public Mains getMain() {
		return main;
	}


	public void setMain(Mains main) {
		this.main = main;
	}

	public List<LeagueChampion> getTiera() {
		return tiera;
	}

	public void setTiera(List<LeagueChampion> tiera) {
		this.tiera = tiera;
	}


	public List<LeagueChampion> getTierb() {
		return tierb;
	}


	public void setTierb(List<LeagueChampion> tierb) {
		this.tierb = tierb;
	}


	public List<LeagueChampion> getTierc() {
		return tierc;
	}


	public void setTierc(List<LeagueChampion> tierc) {
		this.tierc = tierc;
	}


	public List<LeagueChampion> getTierd() {
		return tierd;
	}


	public void setTierd(List<LeagueChampion> tierd) {
		this.tierd = tierd;
	}
	
	
}
