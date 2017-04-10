package com.lolmains.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="masteries")
public class Masteries {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(columnDefinition="text",name="description")
	private String description;
	@Column(name="tree_1_1")
	private int tree_1_1;
	@Column(name="tree_1_2")
	private int tree_1_2;
	@Column(name="tree_1_3")
	private int tree_1_3;
	@Column(name="tree_1_4")
	private int tree_1_4;
	@Column(name="tree_1_5")
	private int tree_1_5;
	@Column(name="tree_1_6")
	private int tree_1_6;
	@Column(name="tree_1_7")
	private int tree_1_7;
	@Column(name="tree_1_8")
	private int tree_1_8;
	@Column(name="tree_1_9")
	private int tree_1_9;
	@Column(name="tree_1_10")
	private int tree_1_10;
	@Column(name="tree_1_11")
	private int tree_1_11;
	@Column(name="tree_1_12")
	private int tree_1_12;
	@Column(name="tree_1_13")
	private int tree_1_13;
	@Column(name="tree_1_14")
	private int tree_1_14;
	@Column(name="tree_1_15")
	private int tree_1_15;
	
	@Column(name="tree_2_1")
	private int tree_2_1;
	@Column(name="tree_2_2")
	private int tree_2_2;
	@Column(name="tree_2_3")
	private int tree_2_3;
	@Column(name="tree_2_4")
	private int tree_2_4;
	@Column(name="tree_2_5")
	private int tree_2_5;
	@Column(name="tree_2_6")
	private int tree_2_6;
	@Column(name="tree_2_7")
	private int tree_2_7;
	@Column(name="tree_2_8")
	private int tree_2_8;
	@Column(name="tree_2_9")
	private int tree_2_9;
	@Column(name="tree_2_10")
	private int tree_2_10;
	@Column(name="tree_2_11")
	private int tree_2_11;
	@Column(name="tree_2_12")
	private int tree_2_12;
	@Column(name="tree_2_13")
	private int tree_2_13;
	@Column(name="tree_2_14")
	private int tree_2_14;
	@Column(name="tree_2_15")
	private int tree_2_15;
	
	@Column(name="tree_3_1")
	private int tree_3_1;
	@Column(name="tree_3_2")
	private int tree_3_2;
	@Column(name="tree_3_3")
	private int tree_3_3;
	@Column(name="tree_3_4")
	private int tree_3_4;
	@Column(name="tree_3_5")
	private int tree_3_5;
	@Column(name="tree_3_6")
	private int tree_3_6;
	@Column(name="tree_3_7")
	private int tree_3_7;
	@Column(name="tree_3_8")
	private int tree_3_8;
	@Column(name="tree_3_9")
	private int tree_3_9;
	@Column(name="tree_3_10")
	private int tree_3_10;
	@Column(name="tree_3_11")
	private int tree_3_11;
	@Column(name="tree_3_12")
	private int tree_3_12;
	@Column(name="tree_3_13")
	private int tree_3_13;
	@Column(name="tree_3_14")
	private int tree_3_14;
	@Column(name="tree_3_15")
	private int tree_3_15;
	@Column(name="keystone")
	private String keystone;
	
	
	
	
	public Masteries() {
		super();
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
	public int getTree_1_1() {
		return tree_1_1;
	}
	public void setTree_1_1(int tree_1_1) {
		this.tree_1_1 = tree_1_1;
	}
	public int getTree_1_2() {
		return tree_1_2;
	}
	public void setTree_1_2(int tree_1_2) {
		this.tree_1_2 = tree_1_2;
	}
	public int getTree_1_3() {
		return tree_1_3;
	}
	public void setTree_1_3(int tree_1_3) {
		this.tree_1_3 = tree_1_3;
	}
	public int getTree_1_4() {
		return tree_1_4;
	}
	public void setTree_1_4(int tree_1_4) {
		this.tree_1_4 = tree_1_4;
	}
	public int getTree_1_5() {
		return tree_1_5;
	}
	public void setTree_1_5(int tree_1_5) {
		this.tree_1_5 = tree_1_5;
	}
	public int getTree_1_6() {
		return tree_1_6;
	}
	public void setTree_1_6(int tree_1_6) {
		this.tree_1_6 = tree_1_6;
	}
	public int getTree_1_7() {
		return tree_1_7;
	}
	public void setTree_1_7(int tree_1_7) {
		this.tree_1_7 = tree_1_7;
	}
	public int getTree_1_8() {
		return tree_1_8;
	}
	public void setTree_1_8(int tree_1_8) {
		this.tree_1_8 = tree_1_8;
	}
	public int getTree_1_9() {
		return tree_1_9;
	}
	public void setTree_1_9(int tree_1_9) {
		this.tree_1_9 = tree_1_9;
	}
	public int getTree_1_10() {
		return tree_1_10;
	}
	public void setTree_1_10(int tree_1_10) {
		this.tree_1_10 = tree_1_10;
	}
	public int getTree_1_11() {
		return tree_1_11;
	}
	public void setTree_1_11(int tree_1_11) {
		this.tree_1_11 = tree_1_11;
	}
	public int getTree_1_12() {
		return tree_1_12;
	}
	public void setTree_1_12(int tree_1_12) {
		this.tree_1_12 = tree_1_12;
	}
	public int getTree_1_13() {
		return tree_1_13;
	}
	public void setTree_1_13(int tree_1_13) {
		this.tree_1_13 = tree_1_13;
	}
	public int getTree_1_14() {
		return tree_1_14;
	}
	public void setTree_1_14(int tree_1_14) {
		this.tree_1_14 = tree_1_14;
	}
	public int getTree_1_15() {
		return tree_1_15;
	}
	public void setTree_1_15(int tree_1_15) {
		this.tree_1_15 = tree_1_15;
	}
	public int getTree_2_1() {
		return tree_2_1;
	}
	public void setTree_2_1(int tree_2_1) {
		this.tree_2_1 = tree_2_1;
	}
	public int getTree_2_2() {
		return tree_2_2;
	}
	public void setTree_2_2(int tree_2_2) {
		this.tree_2_2 = tree_2_2;
	}
	public int getTree_2_3() {
		return tree_2_3;
	}
	public void setTree_2_3(int tree_2_3) {
		this.tree_2_3 = tree_2_3;
	}
	public int getTree_2_4() {
		return tree_2_4;
	}
	public void setTree_2_4(int tree_2_4) {
		this.tree_2_4 = tree_2_4;
	}
	public int getTree_2_5() {
		return tree_2_5;
	}
	public void setTree_2_5(int tree_2_5) {
		this.tree_2_5 = tree_2_5;
	}
	public int getTree_2_6() {
		return tree_2_6;
	}
	public void setTree_2_6(int tree_2_6) {
		this.tree_2_6 = tree_2_6;
	}
	public int getTree_2_7() {
		return tree_2_7;
	}
	public void setTree_2_7(int tree_2_7) {
		this.tree_2_7 = tree_2_7;
	}
	public int getTree_2_8() {
		return tree_2_8;
	}
	public void setTree_2_8(int tree_2_8) {
		this.tree_2_8 = tree_2_8;
	}
	public int getTree_2_9() {
		return tree_2_9;
	}
	public void setTree_2_9(int tree_2_9) {
		this.tree_2_9 = tree_2_9;
	}
	public int getTree_2_10() {
		return tree_2_10;
	}
	public void setTree_2_10(int tree_2_10) {
		this.tree_2_10 = tree_2_10;
	}
	public int getTree_2_11() {
		return tree_2_11;
	}
	public void setTree_2_11(int tree_2_11) {
		this.tree_2_11 = tree_2_11;
	}
	public int getTree_2_12() {
		return tree_2_12;
	}
	public void setTree_2_12(int tree_2_12) {
		this.tree_2_12 = tree_2_12;
	}
	public int getTree_2_13() {
		return tree_2_13;
	}
	public void setTree_2_13(int tree_2_13) {
		this.tree_2_13 = tree_2_13;
	}
	public int getTree_2_14() {
		return tree_2_14;
	}
	public void setTree_2_14(int tree_2_14) {
		this.tree_2_14 = tree_2_14;
	}
	public int getTree_2_15() {
		return tree_2_15;
	}
	public void setTree_2_15(int tree_2_15) {
		this.tree_2_15 = tree_2_15;
	}
	public int getTree_3_1() {
		return tree_3_1;
	}
	public void setTree_3_1(int tree_3_1) {
		this.tree_3_1 = tree_3_1;
	}
	public int getTree_3_2() {
		return tree_3_2;
	}
	public void setTree_3_2(int tree_3_2) {
		this.tree_3_2 = tree_3_2;
	}
	public int getTree_3_3() {
		return tree_3_3;
	}
	public void setTree_3_3(int tree_3_3) {
		this.tree_3_3 = tree_3_3;
	}
	public int getTree_3_4() {
		return tree_3_4;
	}
	public void setTree_3_4(int tree_3_4) {
		this.tree_3_4 = tree_3_4;
	}
	public int getTree_3_5() {
		return tree_3_5;
	}
	public void setTree_3_5(int tree_3_5) {
		this.tree_3_5 = tree_3_5;
	}
	public int getTree_3_6() {
		return tree_3_6;
	}
	public void setTree_3_6(int tree_3_6) {
		this.tree_3_6 = tree_3_6;
	}
	public int getTree_3_7() {
		return tree_3_7;
	}
	public void setTree_3_7(int tree_3_7) {
		this.tree_3_7 = tree_3_7;
	}
	public int getTree_3_8() {
		return tree_3_8;
	}
	public void setTree_3_8(int tree_3_8) {
		this.tree_3_8 = tree_3_8;
	}
	public int getTree_3_9() {
		return tree_3_9;
	}
	public void setTree_3_9(int tree_3_9) {
		this.tree_3_9 = tree_3_9;
	}
	public int getTree_3_10() {
		return tree_3_10;
	}
	public void setTree_3_10(int tree_3_10) {
		this.tree_3_10 = tree_3_10;
	}
	public int getTree_3_11() {
		return tree_3_11;
	}
	public void setTree_3_11(int tree_3_11) {
		this.tree_3_11 = tree_3_11;
	}
	public int getTree_3_12() {
		return tree_3_12;
	}
	public void setTree_3_12(int tree_3_12) {
		this.tree_3_12 = tree_3_12;
	}
	public int getTree_3_13() {
		return tree_3_13;
	}
	public void setTree_3_13(int tree_3_13) {
		this.tree_3_13 = tree_3_13;
	}
	public int getTree_3_14() {
		return tree_3_14;
	}
	public void setTree_3_14(int tree_3_14) {
		this.tree_3_14 = tree_3_14;
	}
	public int getTree_3_15() {
		return tree_3_15;
	}
	public void setTree_3_15(int tree_3_15) {
		this.tree_3_15 = tree_3_15;
	}
	public Masteries(String description, int tree_1_1, int tree_1_2, int tree_1_3, int tree_1_4, int tree_1_5,
			int tree_1_6, int tree_1_7, int tree_1_8, int tree_1_9, int tree_1_10, int tree_1_11, int tree_1_12,
			int tree_1_13, int tree_1_14, int tree_1_15, int tree_2_1, int tree_2_2, int tree_2_3, int tree_2_4,
			int tree_2_5, int tree_2_6, int tree_2_7, int tree_2_8, int tree_2_9, int tree_2_10, int tree_2_11,
			int tree_2_12, int tree_2_13, int tree_2_14, int tree_2_15, int tree_3_1, int tree_3_2, int tree_3_3,
			int tree_3_4, int tree_3_5, int tree_3_6, int tree_3_7, int tree_3_8, int tree_3_9, int tree_3_10,
			int tree_3_11, int tree_3_12, int tree_3_13, int tree_3_14, int tree_3_15) {
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
		this.tree_1_10 = tree_1_10;
		this.tree_1_11 = tree_1_11;
		this.tree_1_12 = tree_1_12;
		this.tree_1_13 = tree_1_13;
		this.tree_1_14 = tree_1_14;
		this.tree_1_15 = tree_1_15;
		this.tree_2_1 = tree_2_1;
		this.tree_2_2 = tree_2_2;
		this.tree_2_3 = tree_2_3;
		this.tree_2_4 = tree_2_4;
		this.tree_2_5 = tree_2_5;
		this.tree_2_6 = tree_2_6;
		this.tree_2_7 = tree_2_7;
		this.tree_2_8 = tree_2_8;
		this.tree_2_9 = tree_2_9;
		this.tree_2_10 = tree_2_10;
		this.tree_2_11 = tree_2_11;
		this.tree_2_12 = tree_2_12;
		this.tree_2_13 = tree_2_13;
		this.tree_2_14 = tree_2_14;
		this.tree_2_15 = tree_2_15;
		this.tree_3_1 = tree_3_1;
		this.tree_3_2 = tree_3_2;
		this.tree_3_3 = tree_3_3;
		this.tree_3_4 = tree_3_4;
		this.tree_3_5 = tree_3_5;
		this.tree_3_6 = tree_3_6;
		this.tree_3_7 = tree_3_7;
		this.tree_3_8 = tree_3_8;
		this.tree_3_9 = tree_3_9;
		this.tree_3_10 = tree_3_10;
		this.tree_3_11 = tree_3_11;
		this.tree_3_12 = tree_3_12;
		this.tree_3_13 = tree_3_13;
		this.tree_3_14 = tree_3_14;
		this.tree_3_15 = tree_3_15;
	}
	public String getKeystone() {
		return keystone;
	}
	public void setKeystone(String keystone) {
		this.keystone = keystone;
	}

	
		
	
	
}
