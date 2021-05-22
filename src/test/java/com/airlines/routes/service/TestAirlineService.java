package com.airlines.routes.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Tuple;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.airlines.routes.cache.AirLineRoutesCacheManager;
import com.airlines.routes.repository.AirlineRepository;

public class TestAirlineService {

	@InjectMocks
	AirlineService airlineService;

	@Mock
	AirlineRepository airlineRepository;

	@Mock
	AirLineRoutesCacheManager airLineRoutesCacheManager;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAirlineMaxCitiesCovereage() {
		// Sample O/P
		String[] airlines = { "AA", "AF", "AB" };
		when(airLineRoutesCacheManager.getTopAirlines()).thenReturn(Arrays.asList(airlines));
		// Test
		List<String> airlineList = airlineService.getAirlineMaxCitiesCovereage();
		assertEquals(3, airlineList.size());
		// verify(airlineRepository, times(1)).getAirlineMaxCitiesCovereage();
	}

	@Test
	public void getAirlinesWithDirectRoutes() {
		// Sample O/P
		String[] airlines = { "AA", "AF", "AB" };
		when(airLineRoutesCacheManager.directFlights()).thenReturn(Arrays.asList(airlines));
		// Test
		List<String> airlineList = airlineService.getAirlinesWithDirectRoutes();
		assertEquals(3, airlineList.size());
		// verify(airlineRepository, times(1)).getAirlinesWithDirectRoutes();
	}

	@Test
	public void getTopCitiesInServicing() {
		// Sample O/P
		String[] cities = { "CDG", "DUS", "DFW", "CLT", "MIA", "PHL", "TXL", "CGN", "YYZ", "ATH" };
		when(airLineRoutesCacheManager.getTopCities()).thenReturn(Arrays.asList(cities));
		// Test
		List<String> citiesList = airlineService.getTopCitiesInServicing();
		assertEquals(10, citiesList.size());
		// verify(airlineRepository, times(1)).getTopCitiesInServicing();
	}
}
