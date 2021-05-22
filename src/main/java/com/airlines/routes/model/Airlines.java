package com.airlines.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airlineroutes")
public class Airlines {
	
	@Id
	@Column(name="id")
	private int id;
	private String airlineId;
	private String airline;
	private String sourceAirport;
	private String sourceAirportId;
	private String destinationAirport;
	private String destinationAirportId;
	private String codeshare;
	private String stops;
	private String equipment;
	
	public Airlines(){
		
	}

	public Airlines(String airlineId, String airline, String sourceAirport, String sourceAirportId, String destinationAirport,
			String destinationAirportId, String codeshare, String stops, String equipment) {
		super();
		this.airlineId =airlineId;
		this.airline = airline;
		this.sourceAirport = sourceAirport;
		this.sourceAirportId = sourceAirportId;
		this.destinationAirport = destinationAirport;
		this.destinationAirportId = destinationAirportId;
		this.codeshare = codeshare;
		this.stops = stops;
		this.equipment = equipment;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getSourceAirportId() {
		return sourceAirportId;
	}

	public void setSourceAirportId(String sourceAirportId) {
		this.sourceAirportId = sourceAirportId;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getDestinationAirportId() {
		return destinationAirportId;
	}

	public void setDestinationAirportId(String destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}

	public String getCodeshare() {
		return codeshare;
	}

	public void setCodeshare(String codeshare) {
		this.codeshare = codeshare;
	}

	public String getStops() {
		return stops;
	}

	public void setStops(String stops) {
		this.stops = stops;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return "Airlines [airlineId=" + airlineId + ", airline=" + airline + ", sourceAirport=" + sourceAirport
				+ ", sourceAirportId=" + sourceAirportId + ", destinationAirport=" + destinationAirport
				+ ", destinationAirportId=" + destinationAirportId + ", codeshare=" + codeshare + ", stops=" + stops
				+ ", equipment=" + equipment + "]";
	}
	
	
}
