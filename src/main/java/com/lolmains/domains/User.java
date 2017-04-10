package com.lolmains.domains;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@JoinColumn(name = "summoner")
	@ManyToOne
	private Summoner summoner;
	@JoinColumn(name = "discussion")
	@OneToMany
	@JsonIgnore
	private List<Discussion> discussion;
	@JoinColumn(name = "mains")
	@OneToMany
	private List<Mains> Mains;

	@Column(name="verified")
	private boolean verified;
	@OneToMany(targetEntity=UserRole.class, mappedBy="user", fetch=FetchType.EAGER)
    public Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Summoner getSummoner() {
		return summoner;
	}
	public void setSummoner(Summoner summoner) {
		this.summoner = summoner;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	public List<Discussion> getDiscussion() {
		return discussion;
	}
	public void setDiscussion(List<Discussion> discussion) {
		this.discussion = discussion;
	}
	@JsonIgnore
	public List<Mains> getMains() {
		return Mains;
	}
	public void setMains(List<Mains> mains) {
		Mains = mains;
	}
	

	
}
