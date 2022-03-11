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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import com.OpenClassProject.safetyNetAlert.model.specific.PersonInfo;

import services.JsonService;
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
	@ResponseStatus(code = HttpStatus.OK)
	public List<Person> getAll() {
		return JsService.getAllPersonsFromFile();
	}
	
	
	@PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Person AddPerson (@RequestBody Person person){	
		return PService.createANewPerson(person);
	}
	
	
	@DeleteMapping(path = "/persons")
	@ResponseStatus(code = HttpStatus.OK)
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
	
	
	@GetMapping(path = "/personInfo")
	@ResponseStatus(code = HttpStatus.OK)
	public PersonInfo getPersonInfo(@RequestParam String lastName, String firstName) {
		return PService.personInfo(lastName, firstName);

	}
	
	@GetMapping(path = "/childAlert")
	@ResponseStatus(code = HttpStatus.OK)
	public ChildAlert getChildAlert(@RequestParam String address) {
		return PService.getChildAlert(address);

	}
	
}



