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
@Table(name="link_group")
public class LinkGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@JoinColumn(name="link_id")
	@OneToMany
	private List<Link> link;
	@JoinColumn(name="main_id")
	@ManyToOne
	private Mains main;
	
	
	
	public LinkGroup() {
		super();
	}
	public LinkGroup(String linkGroup, Mains main2) {
		// TODO Auto-generated constructor stub
		name=linkGroup;
		main=main2;
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
	public List<Link> getLink() {
		return link;
	}
	public void setLink(List<Link> link) {
		this.link = link;
	}
	public Mains getMain() {
		return main;
	}
	public void setMain(Mains main) {
		this.main = main;
	}


	
	
}
