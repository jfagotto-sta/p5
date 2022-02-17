package com.OpenClassProject.safetyNetAlert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;

import services.JsonService;

@RestController
public class Controller {
	
	private JsonService Service;

	public Controller(JsonService Service) {
		super();
		this.Service = Service;
	}
	
	@GetMapping(path = "/persons")
	public List<Person> getAll() {
		return Service.getAllPersonsFromFile();
	}
	
	@GetMapping(path = "/firestations")
	public List<Firestation> getAllFirestations(){
		return Service.getAllFirestationsFromFile();
	}
	
	@GetMapping(path = "/medicalrecords")
	public List<Medicalrecords> getAllMedicalRecords(){
		return Service.getAllMedicalRecordsFromFile();
	}
	
//	@GetMapping(path = "/personInfo")
//	public Person getInfo(String firstName, String lastName) {
//		return pService.findAPersonWithHisLastNameAndFirstName(lastName, firstName);
//		
//	}
}
