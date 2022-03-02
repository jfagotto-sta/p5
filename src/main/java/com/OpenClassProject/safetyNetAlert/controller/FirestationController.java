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

import com.OpenClassProject.safetyNetAlert.model.Firestation;

import services.FireStationService;
import services.JsonService;

@RestController
public class FirestationController {
	
	private FireStationService FService;
	private JsonService JsService;
	
	
	public FirestationController(FireStationService fService, JsonService jsService) {
		super();
		FService = fService;
		JsService = jsService;
	}

	@GetMapping(path = "/firestations")
	public List<Firestation> getAllFirestations(){
		return JsService.getAllFirestationsFromFile();
	}
	
	@PostMapping(path = "/firestations")
	public Firestation AddFirestation (@RequestBody Firestation firestation){	
		return FService.createAMappingFirestationAdress(firestation);
	}
	
	@DeleteMapping(path = "/firestations")
	public void deleteAFirestation(@RequestParam Firestation firestation) {
		FService.deleteAFirestation(firestation);
	}
	
	@PutMapping(path = "/firestations", consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
		public void updateAFirestation(@RequestBody Firestation firestations) {
		FService.updateAFirestation(firestations);
	}
	
	

}