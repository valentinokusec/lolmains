package com.lolmains.forms;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CreateTierList {
	

	int mainid;

	ArrayList<Long> tierlista = new ArrayList<Long>();
	
	ArrayList<Long> tierlistb = new ArrayList<Long>();
	
	ArrayList<Long> tierlistc = new ArrayList<Long>();
	
	ArrayList<Long> tierlistd = new ArrayList<Long>();

	public int getMainid() {
		return mainid;
	}

	public void setMainid(int mainid) {
		this.mainid = mainid;
	}

	public ArrayList<Long> getTierlista() {
		return tierlista;
	}

	public void setTierlista(ArrayList<Long> tierlista) {
		this.tierlista = tierlista;
	}

	public ArrayList<Long> getTierlistb() {
		return tierlistb;
	}

	public void setTierlistb(ArrayList<Long> tierlistb) {
		this.tierlistb = tierlistb;
	}

	public ArrayList<Long> getTierlistc() {
		return tierlistc;
	}

	public void setTierlistc(ArrayList<Long> tierlistc) {
		this.tierlistc = tierlistc;
	}

	public ArrayList<Long> getTierlistd() {
		return tierlistd;
	}

	public void setTierlistd(ArrayList<Long> tierlistd) {
		this.tierlistd = tierlistd;
	}

	
	
}
