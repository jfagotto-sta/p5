package com.OpenClassProject.safetyNetAlert.repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class JsonFileRepository implements IRepository {

	private ListIterator<JSONObject> iterator;
	private JSONObject object;
	private JSONParser parser;
	private ObjectMapper mapper;
	
	private List<Person> persons = new ArrayList<>();
	private List<Firestation> firestations = new ArrayList<>();
	private List<Medicalrecords> medicalRecords = new ArrayList<>();
	

	
	private InputStreamReader getFileReader() {
		return new InputStreamReader(getClass().getClassLoader().getResourceAsStream("data/data.json"));
	}
	
	public List<Person> getAllPersonsFromFile() {
		try {
			
			if (persons.isEmpty()) {
			parser = new JSONParser();
			mapper = new ObjectMapper();
			object = (JSONObject) parser.parse(getFileReader());
			JSONArray personsArray = (JSONArray) object.get("persons");
			iterator = personsArray.listIterator();
			while(iterator.hasNext()) {
				persons.add(mapper.readValue(iterator.next().toString(), Person.class));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return persons;	
	}
	
	public List<Firestation> getAllFirestationsFromFile() {
		try {
			if (firestations.isEmpty()) {
			parser = new JSONParser();
			mapper = new ObjectMapper();
			object = (JSONObject) parser.parse(getFileReader());
			JSONArray firestationsArray = (JSONArray) object.get("firestations");
			iterator = firestationsArray.listIterator();
			while(iterator.hasNext()) {
				firestations.add(mapper.readValue(iterator.next().toString(), Firestation.class));
			}
		}	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return firestations;
		
	}
	
	public List<Medicalrecords> getAllMedicalRecordsFromFile() {
		try {
			if (medicalRecords.isEmpty()) {
			parser = new JSONParser();
			mapper = new ObjectMapper();
			object = (JSONObject) parser.parse(getFileReader());
			JSONArray medicalRecordsArray = (JSONArray) object.get("medicalrecords");
			iterator = medicalRecordsArray.listIterator();
			while(iterator.hasNext()) {
				medicalRecords.add(mapper.readValue(iterator.next().toString(), Medicalrecords.class));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return medicalRecords;
		
	}
	
	public void deleteAPerson(String lastName, String firstName) {
		this.persons = getAllPersonsFromFile();		
		Person person = getPersonWithThisLastNameAndFirstName(lastName, firstName);
		if(person != null) {
			this.persons.remove(person);
		}
		
	}
	
	public Person createAPerson (Person person) {
		this.persons = getAllPersonsFromFile();
		persons.add(person);
		return person;
	}
	
	public Person getPersonWithThisLastNameAndFirstName(String lastName, String firstName) {
		this.persons = getAllPersonsFromFile();
		for (Person person : persons) {
			if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				return person;
			}
		}
		return null;
	}
	
	public Firestation getFirestation(String addres, int station) {
		this.firestations = getAllFirestationsFromFile();
		for (Firestation firestation : firestations) {
			if(firestation.getAddress().equals(addres) && firestation.getStation() == station) {
				return firestation;
			}
		}	
		return null;	
	}
	
	public Person updateAPerson (Person person) {
		this.persons = getAllPersonsFromFile();
		Person foundAPersonToUpdate = getPersonWithThisLastNameAndFirstName(person.getLastName(), person.getFirstName());
		if(foundAPersonToUpdate != null) {
			foundAPersonToUpdate.setAddress(person.getAddress());
			foundAPersonToUpdate.setEmail(person.getEmail());
			foundAPersonToUpdate.setPhone(person.getPhone());
			foundAPersonToUpdate.setCity(person.getCity());
			foundAPersonToUpdate.setZip(person.getZip());

			
			return foundAPersonToUpdate;
		}
		return null;
	}
		
	public Firestation createAMappingFirestationAdress(Firestation firestation) {
		this.firestations = getAllFirestationsFromFile();
		firestations.add(firestation);
		return firestation;	
	}
	
	public void deleteAFirestation(Firestation firestation) {
		this.firestations = getAllFirestationsFromFile();
		Optional<Firestation> foundAFiretation = firestations.stream().filter(fs -> fs.equals(firestation)).findFirst();
		if(foundAFiretation.isPresent()) {
			this.firestations.remove(firestation);
		}
	}
		
	public Firestation updateAFirestation (Firestation firestation) {
		this.firestations = getAllFirestationsFromFile();
		Firestation foundAFirestationToUpdate = getFirestation(firestation.getAddress(), firestation.getStation());
		return foundAFirestationToUpdate;
	}
	
	public Medicalrecords createAMedicalRecord(Medicalrecords medicalrecords) {
		this.medicalRecords = getAllMedicalRecordsFromFile();
		medicalRecords.add(medicalrecords);
		return medicalrecords;
		
	}
	
	public void deleteAMedicalrecord(Medicalrecords medicalrecords) {
		this.medicalRecords = getAllMedicalRecordsFromFile();
		Optional<Medicalrecords> foundAMedicalRecords = ((Collection) medicalrecords).stream().filter(fs -> fs.equals(medicalrecords)).findFirst();
		if(foundAMedicalRecords.isPresent()) {
			this.medicalRecords.remove(medicalrecords);
		}
	}	
	
	public Medicalrecords getMdicalReocrdsWithThisLastNameAndFirstName(String lastName, String firstName) {
		this.medicalRecords = getAllMedicalRecordsFromFile();
		for (Medicalrecords medicalrecords : medicalRecords) {
			if(medicalrecords.getFirstName().equals(firstName) && medicalrecords.getLastName().equals(lastName)) {
				return medicalrecords;
			}
		}
		return null;
	}
	
	public void updateAMedicalrecord (Medicalrecords medicalrecords) {
		this.medicalRecords = getAllMedicalRecordsFromFile();
		
		Medicalrecords foundAMedicalRecord = getMdicalReocrdsWithThisLastNameAndFirstName(medicalrecords.getLastName(), medicalrecords.getFirstName());
		if (foundAMedicalRecord != null) {
			foundAMedicalRecord.setBirthdate(medicalrecords.getBirthdate());
			foundAMedicalRecord.setAllergies(medicalrecords.getAllergies());
			foundAMedicalRecord.setMedications(medicalrecords.getMedications());
		}
		
		}
}

	
	
//	
//	public dsdf() {
//		
//		ArrayList<String> retour;
//		List<Person> persons getAllPersonsFromFile();
//		List<MedcialRecords> med = getAllmed;
//		
//		for (MedcialRecords medcialRecords : med) {
//			//si nom et prenom corresponds, alors on ajoute a notre liste de retour : 
//			//age, medications et les allergies

//			
//		}
//		
//		for (Person person : persons) {
//			//si nom et prenom corresponds, alors on ajoute a notre liste de retour : 
//			//email, adresse
//			
//		}
//		return araylist
//	}

