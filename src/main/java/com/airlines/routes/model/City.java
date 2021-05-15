package com.airlines.routes.model;

public class City {

	private String city;
	private int counts;
	
	public City(){
		
	}
	public City(String city, int counts) {
		super();
		this.city = city;
		this.counts = counts;
	}
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public int getCount() {
		return counts;
	}
	public void setCount(int counts) {
		this.counts = counts;
	}
	
	
}
