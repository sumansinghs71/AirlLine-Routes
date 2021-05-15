package com.airlines.routes.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.routes.model.Airline;
import com.airlines.routes.model.City;
import com.airlines.routes.repository.AirlineRepository;

@Service
public class AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;

	public List<String> getAirlineMaxCitiesCovereage() {
		return airlineRepository.getAirlineMaxCitiesCovereage();
	}

	public List<String> getAirlinesWithDirectRoutes() {
		return airlineRepository.getAirlinesWithDirectRoutes();
	
	}

	public List<String> getTopCitiesInServicing() {
		return airlineRepository.getTopCitiesInServicing();
//				.stream().map(t ->t.get(0, String.class)).collect(Collectors.toList());
		
	}
}
