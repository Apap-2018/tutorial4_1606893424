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
import com.apap.tutorial4.repository.PilotDb;
import com.apap.tutorial4.service.PilotService;

//PilotController
@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	//Fungsi menambahkan pilot
	@RequestMapping(value="/pilot/add",method=RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value="/pilot/add",method=RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	//Fungsi untuk melihat pilot berdasarkan license number-nya
	@RequestMapping("/pilot/view")
	public String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber)	;
		List<FlightModel> listFlight= archive.getPilotFlight();	
		
		
		model.addAttribute("pilot",archive);
		model.addAttribute("listFlight",listFlight);
		return "view-pilot";
	}
	
	//Fungsi untuk melihat semua pilot
	@RequestMapping("/pilot/viewall")
	public String viewallPilot(Model model) {
		
		List<PilotModel> listPilot= pilotService.getPilotList();
		
		model.addAttribute("listPilot",listPilot);
		return "viewall-pilot";
	}
	
	//Fungsi untuk menghapus seorang pilot
		@RequestMapping("/pilot/delete/{id}")
		public String deletePilot(Model model , @PathVariable Long id) {
			PilotModel pilot = pilotService.getPilotDetailById(id);
			
			pilotService.deletePilot(pilot);
			
			return "delete";
		}
	
	//Fungsi untuk mengupdate data seorang pilot
		
	@RequestMapping(value="/pilot/update/{id}",method=RequestMethod.GET)
	private String updatePilot(Model model, @PathVariable Long id) {
		PilotModel pilot = pilotService.getPilotDetailById(id);
		model.addAttribute("pilot", pilot);
		return "updatePilot";
	}
		
	
	@RequestMapping(value="/pilot/update/{id}",method=RequestMethod.POST)
	private String updatePilotSubmit(@ModelAttribute PilotModel pilot, @PathVariable Long id) {
		pilotService.updatePilot(pilot);
		return "update";
	}
		
		

}
