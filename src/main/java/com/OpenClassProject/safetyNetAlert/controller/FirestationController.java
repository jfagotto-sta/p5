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

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.specific.ByStationInfo;
import com.OpenClassProject.safetyNetAlert.model.specific.PeopleAtFirestation;
import com.fasterxml.jackson.annotation.JsonView;

import services.JsonService;
import services.ServiceInterface.IFireStationService;

@RestController
public class FirestationController {

	Logger logger = LoggerFactory.getLogger(FirestationController.class);

	private IFireStationService firestationService;
	private JsonService jsonService;

	public FirestationController(IFireStationService fService, JsonService jsService) {
		super();
		firestationService = fService;
		jsonService = jsService;
	}

	@GetMapping(path = "/firestations")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Firestation> getAllFirestations() {
		logger.info("Firestations initialized");
		return jsonService.getAllFirestationsFromFile();
	}

	@PostMapping(path = "/firestations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Firestation AddFirestation(@RequestBody Firestation firestation) {
		logger.info("Firestations created");
		return firestationService.createAMappingFirestationAdress(firestation);
	}

	@DeleteMapping(path = "/firestations", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public boolean deleteAFirestation(@RequestBody Firestation firestation) {
		logger.info("Firestation deleted");
		return firestationService.deleteAFirestation(firestation);
	}

	@PutMapping(path = "/firestations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Firestation updateAFirestation(@RequestBody Firestation firestations) {
		logger.info("Firestation updated");
		return firestationService.updateAFirestation(firestations);
	}

	@GetMapping(path = "/phoneAlert", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public List<String> getPhoneAlert(@RequestParam int station) {
		logger.info("phone alert initialized");
		return firestationService.getPhoneAlert(station);

	}
	
	@JsonView(View.viewFloodStationInfo.class)
	@GetMapping(path = "/flood", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public List<ByStationInfo> getInfoFromStationList(@RequestParam List<String> stations) {
		logger.info("flood alert initialized");
		return firestationService.getInfoFromStationList(stations);
	}
	
	
	@JsonView(View.viewPeopleAtFirestation.class)
	@GetMapping(path = "/firestation", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public PeopleAtFirestation personsCoveredByAFirestation(@RequestParam int stationNumber) {
		logger.info("Persons covered by firestation n°"+stationNumber+" initialized");
		return firestationService.personsCoveredByAFirestation(stationNumber);
	}
}
