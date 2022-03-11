package com.OpenClassProject.safetyNetAlert.repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import com.OpenClassProject.safetyNetAlert.model.specific.PersonInfo;
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
				while (iterator.hasNext()) {
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
				while (iterator.hasNext()) {
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
				while (iterator.hasNext()) {
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
		if (person != null) {
			this.persons.remove(person);
		}

	}

	public Person createAPerson(Person person) {
		this.persons = getAllPersonsFromFile();
		persons.add(person);
		return person;
	}

	public Person getPersonWithThisLastNameAndFirstName(String lastName, String firstName) {
		this.persons = getAllPersonsFromFile();
		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				return person;
			}
		}
		return null;
	}

	public Firestation getFirestation(String addres) {
		this.firestations = getAllFirestationsFromFile();
		for (Firestation firestation : firestations) {
			if (firestation.getAddress().equals(addres)) {
				return firestation;
			}
		}
		return null;
	}

	public Person updateAPerson(Person person) {
		this.persons = getAllPersonsFromFile();
		Person foundAPersonToUpdate = getPersonWithThisLastNameAndFirstName(person.getLastName(),
				person.getFirstName());
		if (foundAPersonToUpdate != null) {
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

	public boolean deleteAFirestation(Firestation firestation) {
		this.firestations = getAllFirestationsFromFile();
		Optional<Firestation> foundAFiretation = firestations.stream().filter(fs -> fs.equals(firestation)).findFirst();
		if (foundAFiretation.isPresent()) {
			return this.firestations.remove(firestation);
		}
		return false;
	}

	public Firestation updateAFirestation(Firestation firestation) {
		this.firestations = getAllFirestationsFromFile();
		Firestation foundAFirestationToUpdate = getFirestation(firestation.getAddress());
		foundAFirestationToUpdate.setStation(firestation.getStation());
		return foundAFirestationToUpdate;
	}

	public Medicalrecords createAMedicalRecord(Medicalrecords medicalrecords) {
		this.medicalRecords = getAllMedicalRecordsFromFile();
		medicalRecords.add(medicalrecords);
		return medicalrecords;

	}

	public boolean deleteAMedicalrecord(String lastName, String firstName) {
		this.medicalRecords = getAllMedicalRecordsFromFile();
		Medicalrecords objectToBeRemoved = null;
		for (Medicalrecords mdRecords : medicalRecords) {
			if (mdRecords.getLastName().equals(lastName) && mdRecords.getFirstName().equals(firstName)) {
				objectToBeRemoved = mdRecords;
			}
		}
		if (objectToBeRemoved != null) {
			return this.medicalRecords.remove(objectToBeRemoved);
		}
		return false;
	}

	public Medicalrecords getMdicalReocrdsWithThisLastNameAndFirstName(String lastName, String firstName) {
		this.medicalRecords = getAllMedicalRecordsFromFile();
		for (Medicalrecords medicalrecords : medicalRecords) {
			if (medicalrecords.getFirstName().equals(firstName) && medicalrecords.getLastName().equals(lastName)) {
				return medicalrecords;
			}
		}
		return null;
	}

	public Medicalrecords updateAMedicalrecord(Medicalrecords medicalrecords) {
		this.medicalRecords = getAllMedicalRecordsFromFile();

		Medicalrecords foundAMedicalRecord = getMdicalReocrdsWithThisLastNameAndFirstName(medicalrecords.getLastName(),
				medicalrecords.getFirstName());
		if (foundAMedicalRecord != null) {
			foundAMedicalRecord.setBirthdate(medicalrecords.getBirthdate());
			foundAMedicalRecord.setAllergies(medicalrecords.getAllergies());
			foundAMedicalRecord.setMedications(medicalrecords.getMedications());
		}
		return foundAMedicalRecord;
	}

	@Override
	public PersonInfo getPersonInfo(String lastName, String firstName) {
		this.persons = getAllPersonsFromFile();
		this.medicalRecords = getAllMedicalRecordsFromFile();

		Person p = null;
		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				p = person;
			}
		}
		Medicalrecords m = null;
		for (Medicalrecords medicalrecord : medicalRecords) {
			if (medicalrecord.getFirstName().equals(firstName) && medicalrecord.getLastName().equals(lastName)) {
				m = medicalrecord;
			}
		}
		PersonInfo pInfo = new PersonInfo();
		pInfo.setFirstName(p.getFirstName());
		pInfo.setLastName(p.getLastName());
		pInfo.setEmail(p.getEmail());
		if (m != null) {
			pInfo.setAllergies(m.getAllergies());
			pInfo.setMedications(m.getMedications());
		}

		return pInfo;
	}

	public List<String> getMailAddressesForACity(String city) {
		this.persons = getAllPersonsFromFile();
		List<String> emailList = new ArrayList<>();

		for (Person person : persons) {
			if (person.getCity().equals(city)) {
				emailList.add(person.getEmail());
			}
		}
		return emailList;
	}

	@Override
	public ChildAlert getChildAlert(String address) {
		
		//on va lire toutes les personnes
		//on check si ces personnes habitent a cette adresse
		//si oui et > 17  alors on l'ajoute dans la liste adultes
		//sinon on l'ajoute dans enfant
		
		this.persons = getAllPersonsFromFile();

		Person p = null;
		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				p = person;
			}
		}
		
		ChildAlert pInfo = new ChildAlert();
		pInfo.setFirstName(p.getFirstName());
		pInfo.setLastName(p.getLastName());
		pInfo.setEmail(p.getEmail());
		if (m != null) {
			pInfo.setAllergies(m.getAllergies());
			pInfo.setMedications(m.getMedications());
		}

		return pInfo;
	}
}
