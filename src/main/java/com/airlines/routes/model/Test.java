package com.airlines.routes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Airlines a1 = new Airlines("2","abc", "AUS", "2", "BUS", "1", "0", "2", "2");
		Airlines a2 = new Airlines("2","abc", "BUS", "2", "AUS", "1", "0", "2", "2");
		Airlines a3 = new Airlines("2","bdc", "CUS", "2", "AUS", "1", "0", "2", "2");
		Airlines a4 = new Airlines("2","bdc", "AUS", "2", "CUS", "1", "0", "2", "2");
		Airlines a5 = new Airlines("2","pqr", "NUS", "2", "KUS", "1", "0", "2", "2");
		Airlines a6 = new Airlines("2","sto", "KUS", "2", "MUS", "1", "0", "2", "2");
		Airlines a7 = new Airlines("2","kto", "AUS", "2", "MUS", "1", "0", "2", "2");
		List<Airlines> alsList = new ArrayList<Airlines>();
		List<Airlines> airlinesNewList = new ArrayList<Airlines>();
		alsList.add(a7);
		alsList.add(a6);
		alsList.add(a5);
		alsList.add(a4);
		alsList.add(a3);
		alsList.add(a2);
		alsList.add(a1);
		Map<String, Integer> airLinesMaps= new HashMap<String, Integer>();
		alsList.stream().forEach(x -> {
			int length = (int) airlinesNewList.stream()
					.filter(y -> y.getSourceAirport().equalsIgnoreCase(x.getDestinationAirport())
							&& y.getDestinationAirport().equalsIgnoreCase(x.getSourceAirport()))
					.count();
			if (length > 0) {
				String key = x.getAirline()+ "-" + x.getDestinationAirport().trim().toLowerCase() + "-"
						+ x.getSourceAirport().trim().toLowerCase();
				if (airLinesMaps.containsKey(key)) {
					airLinesMaps.put(key, airLinesMaps.get(key) + 1);
				} else {
					airLinesMaps.put(key, 1);
				}
			} else {
				airlinesNewList.add(x);
				String key = x.getAirline()+ "-" + x.getSourceAirport().trim().toLowerCase() + "-"
						+ x.getDestinationAirport().trim().toLowerCase();
				if (airLinesMaps.containsKey(key)) {
					airLinesMaps.put(key, airLinesMaps.get(key) + 1);
				} else {
					airLinesMaps.put(key, 1);
				}
			}
		});
		for(Airlines a: airlinesNewList){
			System.out.println(a.toString());
		}
		
		for(Map.Entry<String, Integer> aa: airLinesMaps.entrySet()){
			System.out.println(aa.getKey()+"     "+aa.getValue());
		}

	}

}
