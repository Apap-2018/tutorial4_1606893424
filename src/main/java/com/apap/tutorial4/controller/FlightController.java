package com.apap.tutorial4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.FlightService;
import com.apap.tutorial4.service.PilotService;

//FlightController
@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	//Fungsi menambahkan penerbangan
	@RequestMapping(value="/flight/add/{licenseNumber}",method=RequestMethod.GET)
	private String add(@PathVariable(value="licenseNumber")String licenseNumber,Model model) {
		FlightModel flight=new FlightModel();
		PilotModel pilot=pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		
		model.addAttribute("flight", flight);
		return "addFlight";
		
	} 
	
	@RequestMapping(value="/flight/add",method=RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}
	
	//Fungsi untuk melihat semua flight
		@RequestMapping("/flight/viewall")
		public String viewallFlight(Model model) {
			
			List<FlightModel> listFlight= flightService.getFlightList();
			
			model.addAttribute("listFlight",listFlight);
			return "viewall-flight";
		}
		
	//Fungsi untuk menghapus suatu penerbangan
		@RequestMapping("/flight/delete/{id}")
		public String deleteFlight(Model model , @PathVariable Long id) {
			
			FlightModel flight=flightService.getFlightDetailById(id);
			flightService.deleteFlight(flight);
			
			
			return "delete";
		}
		
		
	//Fungsi untuk mengupdate data suatu penerbangan
	
	@RequestMapping(value="/flight/update/{id}",method=RequestMethod.GET)
	private String updateFlight(Model model, @PathVariable Long id) {
		FlightModel flight = flightService.getFlightDetailById(id);
		model.addAttribute("flight", flight);
		return "updateFlight";
	}
		
	
	@RequestMapping(value="/flight/update/{id}",method=RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute FlightModel flight, @PathVariable Long id) {
		flightService.updateFlight(flight);
		return "update";
	}
	
	
	

}
