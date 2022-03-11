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

import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;

import services.JsonService;
import services.MedicalRecordsService;

@RestController
public class MedicalRecordsController {
	
	private MedicalRecordsService MService;
	private JsonService JsService;
	

	
	public MedicalRecordsController(MedicalRecordsService mService, JsonService jsService) {
		super();
		MService = mService;
		JsService = jsService;
	}
	
	
	@GetMapping(path = "/medicalrecords")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Medicalrecords> getAllMedicalRecords(){
		return JsService.getAllMedicalRecordsFromFile();
	}
	
	@PostMapping(path = "/medicalrecords", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Medicalrecords AddFMedicalrecord (@RequestBody Medicalrecords medicalrecord){	
		return MService.createAMedicalRecord(medicalrecord);
	}
	
	@PutMapping(path = "/medicalrecords", consumes = MediaType.APPLICATION_JSON_VALUE, 
		    produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Medicalrecords updateAMedicalrecords(@RequestBody Medicalrecords medicalrecords) {
		return MService.updateAMedicalrecord(medicalrecords);
	}
	
	@DeleteMapping(path = "/medicalrecords")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean deleteAMedicalrecord(@RequestParam String lastName, String firstName) {
		return MService.deleteAMedicalrecord(lastName, firstName);
	}
}
