package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.FlightModel;



//FlightService
public interface FlightService {
	void addFlight(FlightModel flight);


	List<FlightModel> getFlightList();
	
	FlightModel getFlightDetailById(long id);
	
	void deleteFlight(FlightModel flight);
	
	void updateFlight(FlightModel flight);

}
