package com.OpenClassProject.safetyNetAlert.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.OpenClassProject.safetyNetAlert.model.specific.AllInfoFromPerson;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import com.fasterxml.jackson.annotation.JsonView;

import services.JsonService;
import services.PersonService;

@RestController
public class PersonController {

	Logger logger = LoggerFactory.getLogger(PersonController.class);
	
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
		logger.info("Persons initialized");
		return JsService.getAllPersonsFromFile();
	}
	
	
	@PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Person AddPerson (@RequestBody Person person){	
		logger.info("Person created");
		return PService.createANewPerson(person);
	}
	
	
	@DeleteMapping(path = "/persons")
	@ResponseStatus(code = HttpStatus.OK)
	public String deleteAPerson(@RequestParam String lastName, String firstName) {
		logger.info("Person deleted");
		PService.deleteAPerson(lastName, firstName);
		return "test";
	}
	
	
	@PutMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Person updateAPerson(@RequestBody Person person) {
		logger.info("Person updated");
		return PService.updateAPerson(person);
	}
	
	
	@JsonView(View.viewPersonInfo.class)
	@GetMapping(path = "/personInfo")
	@ResponseStatus(code = HttpStatus.OK)
	public List<AllInfoFromPerson> getPersonInfo(@RequestParam String lastName, String firstName) {
		logger.info("Person informations initialized");
		return PService.personInfo(lastName, firstName);

	}
	
	@JsonView(View.viewChildAlert.class)
	@GetMapping(path = "/childAlert", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ChildAlert getChildAlert(@RequestParam String address) {
		logger.info("Child Alert initialized");
		return PService.getChildAlert(address);

	}
	
	@JsonView(View.viewPersonLivingInAddress.class)
	@GetMapping(path = "/fire", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public List<AllInfoFromPerson> getPersonLivingAtThisAddress(@RequestParam String address) {
		logger.info("Person living at"+ address + "initialized");
		return PService.getPersonLivingInThisAddress(address);

	}
}



