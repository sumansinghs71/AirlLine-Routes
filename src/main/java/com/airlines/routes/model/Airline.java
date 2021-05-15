package com.airlines.routes.model;

public class Airline {

	private String airline;
	private int counts;
	
	public Airline(){
		
	}
	public Airline(String airline, int counts) {
		super();
		this.airline = airline;
		this.counts = counts;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public int getCount() {
		return counts;
	}
	public void setCount(int counts) {
		this.counts = counts;
	}
	
	
}
