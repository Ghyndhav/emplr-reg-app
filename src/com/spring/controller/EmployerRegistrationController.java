package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.bo.EmployerRegistration;
import com.spring.manager.EmployerRegistrationManager;

@Controller
@RequestMapping("/employerRegistrationController")
public class EmployerRegistrationController {
	
	@Autowired
	private EmployerRegistrationManager employerRegistrationManager;
	
	@RequestMapping("/searchEmployerRegistrations")
	public String searchEmployerRegistrations(Model theModel){
		
		List<EmployerRegistration> employerRegistrations=employerRegistrationManager.searchEmployerRegistrations();
		
		theModel.addAttribute("allEmployerRegistrations", employerRegistrations);
		return "employers-registrations";
	}
	
	@GetMapping("/addEmployerRegistration")
	public String addEmployerRegistration(Model theModel) {
		
		EmployerRegistration employerRegistration = new EmployerRegistration();
		
		theModel.addAttribute("employerRegistration", employerRegistration);
		
		return "employer-registration";
		
	}
	
	@PostMapping("/saveEmployerRegistration")
	public String saveEmployerRegistration(@ModelAttribute("employerRegistration") EmployerRegistration employerRegistration) {
		
		employerRegistrationManager.saveEmployerRegistration(employerRegistration);
		
		return "redirect:/employerRegistrationController/searchEmployerRegistrations";
		
	}
	
	@GetMapping("/updateEmployerRegistration")
	public String updateEmployerRegistration(@RequestParam("employerRegistrationId") int id
									,Model theModel) {
		
		EmployerRegistration employerRegistration = employerRegistrationManager.searchEmployerRegistration(id);
		
		theModel.addAttribute("employerRegistration", employerRegistration);
		return "employer-registration";
	}
	
	@GetMapping("/deleteEmployerRegistration")
	public String deleteEmployerRegistration(@RequestParam("employerRegistrationId") int id,Model theModel) {
		employerRegistrationManager.deleteEmployerRegistration(id);
		return "redirect:/employerRegistrationController/searchEmployerRegistrations";
	}

	@RequestMapping(value="/searchEmployer", method=RequestMethod.POST)
	public String searchEmployer(@RequestParam(name="emplrName") String emplrName
									,Model theModel) {

		List<EmployerRegistration> employerRegistrations = employerRegistrationManager.searchEmployerRegistration(emplrName);
		
		theModel.addAttribute("employerRegistrations", employerRegistrations);
		if (employerRegistrations.isEmpty()) {
			theModel.addAttribute("message", "No Employer Registrations Found for the Last Name.");
		}
		return "employers-registrations";
	}
}
