package com.apap.tutorial4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.FlightDb;

//FlightServiceImpl
@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;

	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FlightModel> getFlightList() {
		// TODO Auto-generated method stub
		return flightDb.findAll();
	}

	

	@Override
	public void deleteFlight(FlightModel flight) {
		// TODO Auto-generated method stub
		flightDb.delete(flight);
		
	}

	@Override
	public FlightModel getFlightDetailById(long id) {
		// TODO Auto-generated method stub
		return flightDb.findById(id);
	}

	@Override
	public void updateFlight(FlightModel flight) {
		// TODO Auto-generated method stub
		FlightModel updatedFlight = flightDb.findById(flight.getId());
		
		updatedFlight.setOrigin(flight.getOrigin());
		updatedFlight.setDestination(flight.getDestination());
		updatedFlight.setTime(flight.getTime());
		updatedFlight.setFlightNumber(flight.getFlightNumber());
		
	}
	
	
	
	
	
	
	
	

	
	
	
	

}
