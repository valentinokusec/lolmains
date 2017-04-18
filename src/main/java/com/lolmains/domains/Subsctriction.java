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
@Table(name = "substriction")
public class Subsctriction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int id;
	@JoinColumn(name = "main")
	@ManyToOne
	@JsonBackReference
	private Mains main;

	@JoinColumn(name = "substrictionitem")
	@OneToMany(cascade = CascadeType.ALL)
	private List<SubsctrictionItem> substrictionitem;

	@Column(name = "header")
	public String header;
	@Column(columnDefinition = "VARCHAR(255)", name = "content")
	public String content;

	@Column(name = "date")
	public Timestamp date;

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

	public List<SubsctrictionItem> getSubstrictionitem() {
		return substrictionitem;
	}

	public void setSubstrictionitem(List<SubsctrictionItem> substrictionitem) {
		this.substrictionitem = substrictionitem;
	}

}
