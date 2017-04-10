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
@Table(name="runes")
public class Runes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(columnDefinition="text",name="description")
	private String description;
	@JoinColumn(name = "tree_1_1")
	@ManyToOne
	private LeagueRunes tree_1_1;
	@JoinColumn(name = "tree_1_2")
	@ManyToOne
	private LeagueRunes tree_1_2;
	@JoinColumn(name = "tree_1_3")
	@ManyToOne
	private LeagueRunes tree_1_3;
	@JoinColumn(name = "tree_1_4")
	@ManyToOne
	private LeagueRunes tree_1_4;
	@JoinColumn(name = "tree_1_5")
	@ManyToOne
	private LeagueRunes tree_1_5;
	@JoinColumn(name = "tree_1_6")
	@ManyToOne
	private LeagueRunes tree_1_6;
	@JoinColumn(name = "tree_1_7")
	@ManyToOne
	private LeagueRunes tree_1_7;
	@JoinColumn(name = "tree_1_8")
	@ManyToOne
	private LeagueRunes tree_1_8;
	@JoinColumn(name = "tree_1_9")
	@ManyToOne
	private LeagueRunes tree_1_9;

	
	@JoinColumn(name = "tree_2_1")
	@ManyToOne
	private LeagueRunes tree_2_1;
	@JoinColumn(name = "tree_2_2")
	@ManyToOne
	private LeagueRunes tree_2_2;
	@JoinColumn(name = "tree_2_3")
	@ManyToOne
	private LeagueRunes tree_2_3;
	@JoinColumn(name = "tree_2_4")
	@ManyToOne
	private LeagueRunes tree_2_4;
	@JoinColumn(name = "tree_2_5")
	@ManyToOne
	private LeagueRunes tree_2_5;
	@JoinColumn(name = "tree_2_6")
	@ManyToOne
	private LeagueRunes tree_2_6;
	@JoinColumn(name = "tree_2_7")
	@ManyToOne
	private LeagueRunes tree_2_7;
	@JoinColumn(name = "tree_2_8")
	@ManyToOne
	private LeagueRunes tree_2_8;
	@JoinColumn(name = "tree_2_9")
	@ManyToOne
	private LeagueRunes tree_2_9;

	
	@JoinColumn(name = "tree_3_1")
	@ManyToOne
	private LeagueRunes tree_3_1;
	@JoinColumn(name = "tree_3_2")
	@ManyToOne
	private LeagueRunes tree_3_2;
	@JoinColumn(name = "tree_3_3")
	@ManyToOne
	private LeagueRunes tree_3_3;
	@JoinColumn(name = "tree_3_4")
	@ManyToOne
	private LeagueRunes tree_3_4;
	@JoinColumn(name = "tree_3_5")
	@ManyToOne
	private LeagueRunes tree_3_5;
	@JoinColumn(name = "tree_3_6")
	@ManyToOne
	private LeagueRunes tree_3_6;
	@JoinColumn(name = "tree_3_7")
	@ManyToOne
	private LeagueRunes tree_3_7;
	@JoinColumn(name = "tree_3_8")
	@ManyToOne
	private LeagueRunes tree_3_8;
	@JoinColumn(name = "tree_3_9")
	@ManyToOne
	private LeagueRunes tree_3_9;
	
	@JoinColumn(name = "tree_4_1")
	@ManyToOne
	private LeagueRunes tree_4_1;
	@JoinColumn(name = "tree_4_2")
	@ManyToOne
	private LeagueRunes tree_4_2;
	@JoinColumn(name = "tree_4_3")
	@ManyToOne
	private LeagueRunes tree_4_3;
	
	
	
	
	public Runes() {
		super();
	}
	public Runes(String description, LeagueRunes tree_1_1, LeagueRunes tree_1_2, LeagueRunes tree_1_3,
			LeagueRunes tree_1_4, LeagueRunes tree_1_5, LeagueRunes tree_1_6, LeagueRunes tree_1_7,
			LeagueRunes tree_1_8, LeagueRunes tree_1_9, LeagueRunes tree_2_1, LeagueRunes tree_2_2,
			LeagueRunes tree_2_3, LeagueRunes tree_2_4, LeagueRunes tree_2_5, LeagueRunes tree_2_6,
			LeagueRunes tree_2_7, LeagueRunes tree_2_8, LeagueRunes tree_2_9, LeagueRunes tree_3_1,
			LeagueRunes tree_3_2, LeagueRunes tree_3_3, LeagueRunes tree_3_4, LeagueRunes tree_3_5,
			LeagueRunes tree_3_6, LeagueRunes tree_3_7, LeagueRunes tree_3_8, LeagueRunes tree_3_9,
			LeagueRunes tree_4_1, LeagueRunes tree_4_2, LeagueRunes tree_4_3) {
		super();
		this.description = description;
		this.tree_1_1 = tree_1_1;
		this.tree_1_2 = tree_1_2;
		this.tree_1_3 = tree_1_3;
		this.tree_1_4 = tree_1_4;
		this.tree_1_5 = tree_1_5;
		this.tree_1_6 = tree_1_6;
		this.tree_1_7 = tree_1_7;
		this.tree_1_8 = tree_1_8;
		this.tree_1_9 = tree_1_9;
		this.tree_2_1 = tree_2_1;
		this.tree_2_2 = tree_2_2;
		this.tree_2_3 = tree_2_3;
		this.tree_2_4 = tree_2_4;
		this.tree_2_5 = tree_2_5;
		this.tree_2_6 = tree_2_6;
		this.tree_2_7 = tree_2_7;
		this.tree_2_8 = tree_2_8;
		this.tree_2_9 = tree_2_9;
		this.tree_3_1 = tree_3_1;
		this.tree_3_2 = tree_3_2;
		this.tree_3_3 = tree_3_3;
		this.tree_3_4 = tree_3_4;
		this.tree_3_5 = tree_3_5;
		this.tree_3_6 = tree_3_6;
		this.tree_3_7 = tree_3_7;
		this.tree_3_8 = tree_3_8;
		this.tree_3_9 = tree_3_9;
		this.tree_4_1 = tree_4_1;
		this.tree_4_2 = tree_4_2;
		this.tree_4_3 = tree_4_3;
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
	public LeagueRunes getTree_1_1() {
		return tree_1_1;
	}
	public void setTree_1_1(LeagueRunes tree_1_1) {
		this.tree_1_1 = tree_1_1;
	}
	public LeagueRunes getTree_1_2() {
		return tree_1_2;
	}
	public void setTree_1_2(LeagueRunes tree_1_2) {
		this.tree_1_2 = tree_1_2;
	}
	public LeagueRunes getTree_1_3() {
		return tree_1_3;
	}
	public void setTree_1_3(LeagueRunes tree_1_3) {
		this.tree_1_3 = tree_1_3;
	}
	public LeagueRunes getTree_1_4() {
		return tree_1_4;
	}
	public void setTree_1_4(LeagueRunes tree_1_4) {
		this.tree_1_4 = tree_1_4;
	}
	public LeagueRunes getTree_1_5() {
		return tree_1_5;
	}
	public void setTree_1_5(LeagueRunes tree_1_5) {
		this.tree_1_5 = tree_1_5;
	}
	public LeagueRunes getTree_1_6() {
		return tree_1_6;
	}
	public void setTree_1_6(LeagueRunes tree_1_6) {
		this.tree_1_6 = tree_1_6;
	}
	public LeagueRunes getTree_1_7() {
		return tree_1_7;
	}
	public void setTree_1_7(LeagueRunes tree_1_7) {
		this.tree_1_7 = tree_1_7;
	}
	public LeagueRunes getTree_1_8() {
		return tree_1_8;
	}
	public void setTree_1_8(LeagueRunes tree_1_8) {
		this.tree_1_8 = tree_1_8;
	}
	public LeagueRunes getTree_1_9() {
		return tree_1_9;
	}
	public void setTree_1_9(LeagueRunes tree_1_9) {
		this.tree_1_9 = tree_1_9;
	}
	public LeagueRunes getTree_2_1() {
		return tree_2_1;
	}
	public void setTree_2_1(LeagueRunes tree_2_1) {
		this.tree_2_1 = tree_2_1;
	}
	public LeagueRunes getTree_2_2() {
		return tree_2_2;
	}
	public void setTree_2_2(LeagueRunes tree_2_2) {
		this.tree_2_2 = tree_2_2;
	}
	public LeagueRunes getTree_2_3() {
		return tree_2_3;
	}
	public void setTree_2_3(LeagueRunes tree_2_3) {
		this.tree_2_3 = tree_2_3;
	}
	public LeagueRunes getTree_2_4() {
		return tree_2_4;
	}
	public void setTree_2_4(LeagueRunes tree_2_4) {
		this.tree_2_4 = tree_2_4;
	}
	public LeagueRunes getTree_2_5() {
		return tree_2_5;
	}
	public void setTree_2_5(LeagueRunes tree_2_5) {
		this.tree_2_5 = tree_2_5;
	}
	public LeagueRunes getTree_2_6() {
		return tree_2_6;
	}
	public void setTree_2_6(LeagueRunes tree_2_6) {
		this.tree_2_6 = tree_2_6;
	}
	public LeagueRunes getTree_2_7() {
		return tree_2_7;
	}
	public void setTree_2_7(LeagueRunes tree_2_7) {
		this.tree_2_7 = tree_2_7;
	}
	public LeagueRunes getTree_2_8() {
		return tree_2_8;
	}
	public void setTree_2_8(LeagueRunes tree_2_8) {
		this.tree_2_8 = tree_2_8;
	}
	public LeagueRunes getTree_2_9() {
		return tree_2_9;
	}
	public void setTree_2_9(LeagueRunes tree_2_9) {
		this.tree_2_9 = tree_2_9;
	}
	public LeagueRunes getTree_3_1() {
		return tree_3_1;
	}
	public void setTree_3_1(LeagueRunes tree_3_1) {
		this.tree_3_1 = tree_3_1;
	}
	public LeagueRunes getTree_3_2() {
		return tree_3_2;
	}
	public void setTree_3_2(LeagueRunes tree_3_2) {
		this.tree_3_2 = tree_3_2;
	}
	public LeagueRunes getTree_3_3() {
		return tree_3_3;
	}
	public void setTree_3_3(LeagueRunes tree_3_3) {
		this.tree_3_3 = tree_3_3;
	}
	public LeagueRunes getTree_3_4() {
		return tree_3_4;
	}
	public void setTree_3_4(LeagueRunes tree_3_4) {
		this.tree_3_4 = tree_3_4;
	}
	public LeagueRunes getTree_3_5() {
		return tree_3_5;
	}
	public void setTree_3_5(LeagueRunes tree_3_5) {
		this.tree_3_5 = tree_3_5;
	}
	public LeagueRunes getTree_3_6() {
		return tree_3_6;
	}
	public void setTree_3_6(LeagueRunes tree_3_6) {
		this.tree_3_6 = tree_3_6;
	}
	public LeagueRunes getTree_3_7() {
		return tree_3_7;
	}
	public void setTree_3_7(LeagueRunes tree_3_7) {
		this.tree_3_7 = tree_3_7;
	}
	public LeagueRunes getTree_3_8() {
		return tree_3_8;
	}
	public void setTree_3_8(LeagueRunes tree_3_8) {
		this.tree_3_8 = tree_3_8;
	}
	public LeagueRunes getTree_3_9() {
		return tree_3_9;
	}
	public void setTree_3_9(LeagueRunes tree_3_9) {
		this.tree_3_9 = tree_3_9;
	}
	public LeagueRunes getTree_4_1() {
		return tree_4_1;
	}
	public void setTree_4_1(LeagueRunes tree_4_1) {
		this.tree_4_1 = tree_4_1;
	}
	public LeagueRunes getTree_4_2() {
		return tree_4_2;
	}
	public void setTree_4_2(LeagueRunes tree_4_2) {
		this.tree_4_2 = tree_4_2;
	}
	public LeagueRunes getTree_4_3() {
		return tree_4_3;
	}
	public void setTree_4_3(LeagueRunes tree_4_3) {
		this.tree_4_3 = tree_4_3;
	}
	
	
	
}
