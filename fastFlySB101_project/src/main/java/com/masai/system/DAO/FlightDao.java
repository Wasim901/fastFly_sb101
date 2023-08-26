package com.masai.system.DAO;

import java.util.List;

import com.masai.system.DTO.Flight;

public interface FlightDao {

	public void addFlight(Flight flight);
	public Flight getFlightById(int flightId);
	public List<Flight> getAllFlights();
	public void updateFlight(Flight flight);
	public void deleteFlightById(int flightId);
    public List<Flight> searchFlights(String departureCity, String destinationCity, String departureDate);
	
}
