package com.airlines.routes.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.routes.cache.AirLineRoutesCacheManager;
import com.airlines.routes.model.Airlines;
import com.airlines.routes.repository.AirlineRepository;


@Service
public class AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private AirLineRoutesCacheManager airLineRoutesCacheManager;
	
	public List<Airlines> getAirLineRoutes() {
		return airlineRepository.getAirLineRoutes();
	}

	public List<String> getAirlineMaxCitiesCovereage() {
		return airLineRoutesCacheManager.getTopAirlines();
	}

	public List<String> getAirlinesWithDirectRoutes() {
		return airLineRoutesCacheManager.directFlights();

	}

	public List<String> getTopCitiesInServicing() {
		return airLineRoutesCacheManager.getTopCities();

	}

	

}
