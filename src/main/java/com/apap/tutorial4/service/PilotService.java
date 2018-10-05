package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.PilotModel;

//PilotService
public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	
	void addPilot(PilotModel pilot);
	
	List<PilotModel> getPilotList();
	
	void deletePilot(PilotModel pilot);
	
	PilotModel getPilotDetailById(long id);
	
	void updatePilot(PilotModel pilot);
	
	

}
