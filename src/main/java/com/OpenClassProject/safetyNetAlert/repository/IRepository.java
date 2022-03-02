package com.OpenClassProject.safetyNetAlert.repository;

import java.util.List;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;

public interface IRepository {
	
	public List<Person> getAllPersonsFromFile();
	
	public List<Firestation> getAllFirestationsFromFile();
	
	public List<Medicalrecords> getAllMedicalRecordsFromFile();
	
	public void deleteAPerson(String lastName, String firstName);
	
	public Person createAPerson (Person person);
	
	public Person updateAPerson (Person person);
	
	public Firestation createAMappingFirestationAdress(Firestation firestation);
	
	public void deleteAFirestation(Firestation firestation);
	
	public Firestation updateAFirestation (Firestation firestation);
	
	public Medicalrecords createAMedicalRecord(Medicalrecords medicalrecords);
	
	public void deleteAMedicalrecord(Medicalrecords medicalrecords);
	
	public void updateAMedicalrecord (Medicalrecords medicalrecords);

}
