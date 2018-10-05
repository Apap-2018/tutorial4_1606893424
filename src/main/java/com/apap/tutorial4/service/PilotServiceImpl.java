package com.apap.tutorial4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.PilotDb;

//PilotServiceImpl
@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	private List<PilotModel> listPilot;
	
	@Autowired
	private PilotDb pilotDb;

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return pilotDb.findByLicenseNumber(licenseNumber);
	}

	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PilotModel> getPilotList() {
		// TODO Auto-generated method stub
		return pilotDb.findAll();
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		pilotDb.delete(pilot);
		
	}

	@Override
	public PilotModel getPilotDetailById(long id) {
		// TODO Auto-generated method stub
		return pilotDb.findById(id);
	}

	@Override
	public void updatePilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		PilotModel updatedPilot = pilotDb.findById(pilot.getId());
		
		updatedPilot.setName(pilot.getName());
		updatedPilot.setFlyHour(pilot.getFlyHour());
		
	}
	
	

	
	
	
	
	
	

}
