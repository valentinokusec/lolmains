package com.lolmains.forms;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CreateKnowledge {
	
	
	private int mainsid;
	
	private int type;
	
	ArrayList<Integer> buildlist = new ArrayList<Integer>();
	
	private int param7;
	
	private int param8;
	
	private int param9;
	
	private Long param10;
	
	private int param11;
	
	private String linkGroup;
	
	private String header;
	
	private String url;
	
	private String video;
	
	private String content;	
	
	private Date date;
	
	ArrayList<Integer> combolist = new ArrayList<Integer>();
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getParam7() {
		return param7;
	}
	public void setParam7(int param7) {
		this.param7 = param7;
	}
	public int getParam8() {
		return param8;
	}
	public void setParam8(int param8) {
		this.param8 = param8;
	}
	public Long getParam10() {
		return param10;
	}
	public void setParam10(Long param10) {
		this.param10 = param10;
	}
	public int getParam11() {
		return param11;
	}
	public void setParam11(int param11) {
		this.param11 = param11;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public  int getMainsid() {
		return mainsid;
	}
	public void setMainsid(int mainsid) {
		this.mainsid = mainsid;
	}
	public int getParam9() {
		return param9;
	}
	public void setParam9(int param9) {
		this.param9 = param9;
	}
	public ArrayList<Integer> getCombolist() {
		return combolist;
	}
	public void setCombolist(ArrayList<Integer> combolist) {
		this.combolist = combolist;
	}
	public ArrayList<Integer> getBuildlist() {
		return buildlist;
	}
	public void setBuildlist(ArrayList<Integer> buildlist) {
		this.buildlist = buildlist;
	}
	public String getLinkGroup() {
		return linkGroup;
	}
	public void setLinkGroup(String linkGroup) {
		this.linkGroup = linkGroup;
	}

	

}
