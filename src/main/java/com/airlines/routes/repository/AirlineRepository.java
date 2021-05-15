package com.airlines.routes.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.airlines.routes.model.Airlines;

@Repository
public interface AirlineRepository extends JpaRepository<Airlines, Serializable> {

	@Query(value = "select airline from (SELECT distinct airline, Floor(count(distinct source_airport )+count(distinct destination_airport )) as counts FROM airlineroutes where codeshare !='Y' group by airline order by counts desc limit 3) as res;", nativeQuery = true)
	List<String> getAirlineMaxCitiesCovereage();
	
	@Query(value = "select airline from (select a.airline, Floor(count(a.airline)/2) as counts FROM airlineroutes a, airlineroutes b where a.source_airport=b.destination_airport AND b.source_airport=a.destination_airport group by a.airline order by counts desc limit 3) as res;", nativeQuery = true)
	List<String> getAirlinesWithDirectRoutes();
	
	@Query(value = "select city from (select b.source_airport as city,count(airline) as counts FROM airlineroutes a LEFT JOIN (SELECT source_airport FROM airlineroutes union SELECT destination_airport FROM airlineroutes) as b	ON b.source_airport=a.source_airport where a.codeshare !='Y'group by b.source_airport order by counts desc limit 10) as res;", nativeQuery = true)
	List<String> getTopCitiesInServicing();
}
