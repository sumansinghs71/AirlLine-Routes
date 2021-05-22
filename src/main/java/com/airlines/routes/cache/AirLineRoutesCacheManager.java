package com.airlines.routes.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airlines.routes.constants.AirLineRouteConstants;
import com.airlines.routes.model.Airlines;
import com.airlines.routes.repository.AirlineRepository;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.function.Function;
//import java.util.function.Predicate

@Component
public class AirLineRoutesCacheManager {

	private static final Logger log = LoggerFactory.getLogger(AirLineRoutesCacheManager.class);

	Map<String, Integer> airLinesMap = new HashMap<String, Integer>();
	Map<String, Integer> citysMap = new HashMap<String, Integer>();

	@Autowired
	private AirlineRepository airlineRepository;

	@PostConstruct
	public void initAirlineRoutes() {
		System.out.println("In post Construct ");
		List<Airlines> airlines = airlineRepository.getAirLineRoutes();
		AirLineRouteConstants.AIRLINE_ROUTES.put("data", airlines);
	}

	public List<String> getTopAirlines() {
		List<Airlines> airlinesList = AirLineRouteConstants.AIRLINE_ROUTES.get("data");
		try {
			airlinesList.stream().forEach(row -> {
				addRouteCount(row.getAirline(), row.getSourceAirport());
				addRouteCount(row.getAirline(), row.getDestinationAirport());
			});
		} catch (Exception ex) {
			log.error("Error occured while retrieving top airlines", ex);
		}
		return convertMapToStringList(airLinesMap);
	}

	private void addRouteCount(String airline, String city) {
		String key = airline.trim().toLowerCase() + "-" + city.trim().toLowerCase();
		if (airLinesMap.containsKey(key)) {
			airLinesMap.put(key, airLinesMap.get(key) + 1);
		} else {
			airLinesMap.put(key, 1);
		}
	}

	public List<String> directFlights() {
		List<Airlines> airlinesList = AirLineRouteConstants.AIRLINE_ROUTES.get("data");
		List<Airlines> directFlights = airlinesList.stream().filter(x -> Integer.parseInt(x.getStops()) == 0)
				.collect(Collectors.toList());
		List<Airlines> airlinesNewList = new ArrayList<Airlines>();
		Map<String, Integer> airLinesMaps = new HashMap<String, Integer>();
		try {
			directFlights.stream().forEach(x -> {
				int length = (int) airlinesNewList.stream()
						.filter(y -> y.getSourceAirport().equalsIgnoreCase(x.getDestinationAirport())
								&& y.getDestinationAirport().equalsIgnoreCase(x.getSourceAirport()))
						.count();
				String key = length > 0
						? x.getAirline() + "-" + x.getDestinationAirport().trim().toLowerCase() + "-"
								+ x.getSourceAirport().trim().toLowerCase()
						: x.getAirline() + "-" + x.getSourceAirport().trim().toLowerCase() + "-"
								+ x.getDestinationAirport().trim().toLowerCase();
				if (length == 0) {
					airlinesNewList.add(x);
				}
				if (airLinesMaps.containsKey(key)) {
					airLinesMaps.put(key, airLinesMaps.get(key) + 1);
				} else {
					airLinesMaps.put(key, 1);
				}
			});
		} catch (Exception ex) {
			log.error("Error occured while retrieving direct routes", ex);
		}
		return convertMapToStringList(airLinesMaps);
	}

	public List<String> convertMapToStringList(Map<String, Integer> maps) {
		return maps.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3)
				.map(x -> x.getKey().toString().split("-")[0].toUpperCase()).collect(Collectors.toList());
	}

	public List<String> getTopCities() {
		List<Airlines> airlinesList = AirLineRouteConstants.AIRLINE_ROUTES.get("data");
		List<Airlines> citysWithCodeNoShare = airlinesList.stream().filter(x -> x.getCodeshare().equalsIgnoreCase("Y"))
				.collect(Collectors.toList());
		// citysWithCodeNoShare.stream()
		// .filter(distinctByKeys(Airlines::getSourceAirport,
		// Airlines::getDestinationAirport))
		// .collect(Collectors.toList());
		try {
			citysWithCodeNoShare.stream().forEach(airline -> {
				addCityCount(airline.getAirline(), airline.getSourceAirport());
				addCityCount(airline.getAirline(), airline.getDestinationAirport());
			});
		} catch (Exception ex) {
			log.error("Error occured while retrieving top cities", ex);
		}
		return citysMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(10)
				.map(x -> x.getKey().toString().split("-")[0].toUpperCase()).collect(Collectors.toList());
	}

	private void addCityCount(String airline, String city) {
		String key = city.trim().toLowerCase() + "-" + airline.trim().toLowerCase();
		if (citysMap.containsKey(key)) {
			citysMap.put(key, citysMap.get(key) + 1);
		} else {
			citysMap.put(key, 1);
		}
	}

	// private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>...
	// keyExtractors) {
	// final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();
	//
	// return t -> {
	// final List<?> keys = Arrays.stream(keyExtractors).map(ke ->
	// ke.apply(t)).collect(Collectors.toList());
	// return seen.putIfAbsent(keys, Boolean.TRUE) == null;
	// };
	// }

}
