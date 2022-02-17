package com.OpenClassProject.safetyNetAlert.repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
			parser = new JSONParser();
			mapper = new ObjectMapper();
			object = (JSONObject) parser.parse(getFileReader());
			JSONArray personsArray = (JSONArray) object.get("persons");
			iterator = personsArray.listIterator();
			while(iterator.hasNext()) {
				persons.add(mapper.readValue(iterator.next().toString(), Person.class));
			}
			return persons;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Firestation> getAllFirestationsFromFile() {
		try {
			parser = new JSONParser();
			mapper = new ObjectMapper();
			object = (JSONObject) parser.parse(getFileReader());
			JSONArray firestationsArray = (JSONArray) object.get("firestations");
			iterator = firestationsArray.listIterator();
			while(iterator.hasNext()) {
				firestations.add(mapper.readValue(iterator.next().toString(), Firestation.class));
			}
			return firestations;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Medicalrecords> getAllMedicalRecordsFromFile() {
		try {
			parser = new JSONParser();
			mapper = new ObjectMapper();
			object = (JSONObject) parser.parse(getFileReader());
			JSONArray medicalRecordsArray = (JSONArray) object.get("medicalrecords");
			iterator = medicalRecordsArray.listIterator();
			while(iterator.hasNext()) {
				medicalRecords.add(mapper.readValue(iterator.next().toString(), Medicalrecords.class));
			}
			return medicalRecords;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
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
}
