package com.apap.tutorial4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial4.model.FlightModel;

//FlightDB

@Repository
public interface FlightDb extends JpaRepository<FlightModel,Long>{
	
	FlightModel findById(long id);
	
}
