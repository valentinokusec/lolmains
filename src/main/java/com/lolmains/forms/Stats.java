package com.lolmains.forms;

public class Stats {
	
	private String name;
	private Double value;
	
	
	
	public Stats(String name, Double value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Stats() {
		super();
	}
	
	


}
