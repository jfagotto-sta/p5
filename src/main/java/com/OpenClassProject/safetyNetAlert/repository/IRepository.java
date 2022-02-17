package com.OpenClassProject.safetyNetAlert.repository;

import java.util.List;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;

public interface IRepository {
	
	public List<Person> getAllPersonsFromFile();
	
	public List<Firestation> getAllFirestationsFromFile();
	
	public List<Medicalrecords> getAllMedicalRecordsFromFile();
	
	
}
