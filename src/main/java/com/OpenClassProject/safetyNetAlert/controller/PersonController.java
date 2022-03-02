package com.OpenClassProject.safetyNetAlert.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;

import services.FireStationService;
import services.JsonService;
import services.MedicalRecordsService;
import services.PersonService;

@RestController
public class PersonController {
	
	private JsonService JsService;
	private PersonService PService;


	public PersonController(JsonService JsService, PersonService PService) {
		super();
		this.JsService = JsService;
		this.PService = PService;
	
	}
	
	@GetMapping(path = "/persons")
	public List<Person> getAll() {
		return JsService.getAllPersonsFromFile();
	}
	
	
	
//	@GetMapping(path = "/caserne/adresse")
//	public List<Firestation> getAllFirestations(){
//		return JsService.getAllFirestationsFromFile();
//	}
	
	
	@PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Person AddPerson (@RequestBody Person person){	
		return PService.createANewPerson(person);
	}
	
	
	@DeleteMapping(path = "/persons")
	@ResponseBody
	public String deleteAPerson(@RequestParam String lastName, String firstName) {
		PService.deleteAPerson(lastName, firstName);
		return "test";
	}
	
	
	@PutMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Person updateAPerson(@RequestBody Person person) {
		return PService.updateAPerson(person);
	}
	
	
	
	
	
	
	
}

	
//	@GetMapping(path = "/personInfo")
//	public Person getInfo(String firstName, String lastName) {
//		return pService.findAPersonWithHisLastNameAndFirstName(lastName, firstName);
//		
//	}

