"# AirlLine-Routes" 
Given the description of the file format below, your task is to
1. Identify the top 3 airlines which covers the maximum cities
2. Identify the top 3 airlines which have direct flight 	(src to dst and dst to src should be counted as one)
3. List the top 10 cities in order of number of airlines servicing them


```
Airline                  2-letter (IATA) or 3-letter (ICAO) code of the airline.
Airline ID               Unique OpenFlights identifier for airline (see Airline).
Source airport           3-letter (IATA) or 4-letter (ICAO) code of the source airport.
Source airport ID        Unique OpenFlights identifier for source airport (see Airport)
Destination airport      3-letter (IATA) or 4-letter (ICAO) code of the destination airport.
Destination airport ID   Unique OpenFlights identifier for destination airport (see Airport)
Codeshare                "Y" if this flight is a codeshare (that is, not operated by Airline, but another carrier), empty otherwise.
Stops                    Number of stops on this flight ("0" for direct)
Equipment                3-letter codes for plane type(s) generally used on this flight, separated by space qs
```

The data is UTF-8 encoded. The special value \N is used for "NULL" to indicate that no value is available, and is understood automatically by MySQL if imported.

**Notes:**
>
> *Routes are directional*: if an airline operates services from A to B and from B to A, both A-B and B-A are listed separately.
>
> Routes where one carrier operates both its own and codeshare flights are listed only once.
>
> Is there a need to do special handling based on **codeshare** flag?
