package com.lolmains.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="build")
public class Build {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(columnDefinition="text",name="description")
	private String description;

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
	
	
	
	
	public Build() {
		super();
	}
	public Build(String description, Item item1id, Item item2id, Item item3id, Item item4id, Item item5id,
			Item item6id) {
		super();
		this.description = description;
		this.item1id = item1id;
		this.item2id = item2id;
		this.item3id = item3id;
		this.item4id = item4id;
		this.item5id = item5id;
		this.item6id = item6id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Item getItem4id() {
		return item4id;
	}
	public void setItem4id(Item item4id) {
		this.item4id = item4id;
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
	
	
	
	
	
	
}
