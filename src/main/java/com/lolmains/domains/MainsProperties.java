package com.lolmains.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mainspoperties")
public class MainsProperties {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="bodycolor")
	private String bodycolor;
	@Column(name="cardcolor")
	private String cardcolor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBodycolor() {
		return bodycolor;
	}
	public void setBodycolor(String bodycolor) {
		this.bodycolor = bodycolor;
	}
	public String getCardcolor() {
		return cardcolor;
	}
	public void setCardcolor(String cardcolor) {
		this.cardcolor = cardcolor;
	}

	

	

}
