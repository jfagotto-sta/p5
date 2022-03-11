package com.OpenClassProject.safetyNetAlert.repository;

import java.util.List;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import com.OpenClassProject.safetyNetAlert.model.specific.PersonInfo;

public interface IRepository {
	
	public List<Person> getAllPersonsFromFile();
	
	public List<Firestation> getAllFirestationsFromFile();
	
	public List<Medicalrecords> getAllMedicalRecordsFromFile();
	
	public void deleteAPerson(String lastName, String firstName);
	
	public Person createAPerson (Person person);
	
	public Person updateAPerson (Person person);
	
	public Firestation createAMappingFirestationAdress(Firestation firestation);
	
	public boolean deleteAFirestation(Firestation firestation);
	
	public Firestation updateAFirestation (Firestation firestation);
	
	public Medicalrecords createAMedicalRecord(Medicalrecords medicalrecords);
	
	public boolean deleteAMedicalrecord(String lastName, String firstName);
	
	public Medicalrecords updateAMedicalrecord (Medicalrecords medicalrecords);

	public PersonInfo getPersonInfo(String lastName, String firstName);
	
	public ChildAlert getChildAlert(String address);
}
