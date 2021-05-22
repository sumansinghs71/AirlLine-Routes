package com.airlines.routes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.routes.model.Airline;
import com.airlines.routes.model.Airlines;
import com.airlines.routes.model.City;
import com.airlines.routes.service.AirlineService;

@RestController
@RequestMapping(value = "/api")
public class RoutesController {
	
	@Autowired
	private AirlineService airlineService;
	
	/**
	 *  Identify the top 3 airlines which covers the maximum cities
	 * 
	 */
	@GetMapping("/airlines/maxCoverage")
	public ResponseEntity<List<String>> getAirlineMaxCitiesCovereage() {
	    try {
	    	List<String> airlinesList=airlineService.getAirlineMaxCitiesCovereage();
	    	return new ResponseEntity<List<String>>(airlinesList, HttpStatus.FOUND);
	    }catch (Exception e) {
	    	return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	* Identify the top 3 airlines which have direct flight routes. (src to dst and dst to src should be counted as one)
	* 
	**/
	@GetMapping("/airlines/directRoutes")
	public ResponseEntity<List<String>> getAirlinesWithDirectRoutes() {
	    try {
	    	List<String> airlinesList=airlineService.getAirlinesWithDirectRoutes();
	    	return new ResponseEntity<List<String>>(airlinesList, HttpStatus.FOUND);
	    }catch (Exception e) {
	    	return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	* List the top 10 cities in order of number of airlines servicing them
	* 
	**/
	@GetMapping("/airlines/topCities")
	public ResponseEntity<List<String>> getTopCitiesInServicing() {
	    try {
	    	List<String> cityList=airlineService.getTopCitiesInServicing();
	    	return new ResponseEntity<List<String>>(cityList, HttpStatus.FOUND);
	    }catch (Exception e) {
	    	return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/airlines")
	public ResponseEntity<List<Airlines>> getAirLineRoutes() {
	    try {
	    	List<Airlines> cityList=airlineService.getAirLineRoutes();
	    	return new ResponseEntity<List<Airlines>>(cityList, HttpStatus.FOUND);
	    }catch (Exception e) {
	    	return new ResponseEntity<List<Airlines>>(HttpStatus.NOT_FOUND);
		}
	}
}
