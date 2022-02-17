package com.OpenClassProject.safetyNetAlert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenClassProject.safetyNetAlert.model.Person;

import services.JsonService;
import services.PersonService;

@RestController
public class PersonController {
	
	private JsonService pService;

	public PersonController(JsonService pService) {
		super();
		this.pService = pService;
	}
	
	@GetMapping(path = "/persons")
	public List<Person> getAll() {
		return pService.getAllPersonsFromFile();
	}
	
	
//	@GetMapping(path = "/personInfo")
//	public Person getInfo(String firstName, String lastName) {
//		return pService.findAPersonWithHisLastNameAndFirstName(lastName, firstName);
//		
//	}
}
