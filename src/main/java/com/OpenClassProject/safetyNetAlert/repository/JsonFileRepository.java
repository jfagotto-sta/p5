package com.OpenClassProject.safetyNetAlert.repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.model.specific.AllInfoFromPerson;
import com.OpenClassProject.safetyNetAlert.model.specific.ByStationInfo;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import com.OpenClassProject.safetyNetAlert.model.specific.PeopleAtFirestation;
import com.OpenClassProject.safetyNetAlert.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class JsonFileRepository implements IRepository {

	Logger logger = LoggerFactory.getLogger(JsonFileRepository.class);

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

	@Override
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
			logger.debug("Erreur récupération des objets personne");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return persons;
	}

	@Override
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
			logger.debug("Erreur récupération des objets casernes");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return firestations;

	}

	@Override
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
			logger.debug("Erreur récupération des objets dossiers médicaux");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return medicalRecords;

	}

	@Override
	public void deleteAPerson(String lastName, String firstName) {
		this.persons = getAllPersonsFromFile();
		Person person = getPersonWithThisLastNameAndFirstName(lastName, firstName);
		if (person != null) {
			this.persons.remove(person);
		}

	}

	@Override
	public Person createAPerson(Person person) {
		this.persons = getAllPersonsFromFile();
		persons.add(person);
		return person;
	}

	@Override
	public Person getPersonWithThisLastNameAndFirstName(String lastName, String firstName) {
		this.persons = getAllPersonsFromFile();
		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				return person;
			}
		}
		return null;
	}

	@Override
	public Firestation getFirestation(String addres) {
		this.firestations = getAllFirestationsFromFile();
		for (Firestation firestation : firestations) {
			if (firestation.getAddress().equals(addres)) {
				return firestation;
			}
		}
		return null;
	}

	@Override
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

	@Override
	public Firestation createAMappingFirestationAdress(Firestation firestation) {
		this.firestations = getAllFirestationsFromFile();
		firestations.add(firestation);
		return firestation;
	}

	@Override
	public boolean deleteAFirestation(Firestation firestation) {
		this.firestations = getAllFirestationsFromFile();
		Optional<Firestation> foundAFiretation = firestations.stream().filter(fs -> fs.equals(firestation)).findFirst();
		if (foundAFiretation.isPresent()) {
			return this.firestations.remove(firestation);
		}
		return false;
	}

	@Override
	public Firestation updateAFirestation(Firestation firestation) {
		this.firestations = getAllFirestationsFromFile();
		Firestation foundAFirestationToUpdate = getFirestation(firestation.getAddress());
		foundAFirestationToUpdate.setStation(firestation.getStation());
		return foundAFirestationToUpdate;
	}

	@Override
	public Medicalrecords createAMedicalRecord(Medicalrecords medicalrecords) {
		this.medicalRecords = getAllMedicalRecordsFromFile();
		medicalRecords.add(medicalrecords);
		return medicalrecords;

	}

	@Override
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

	@Override
	public Medicalrecords getMdicalReocrdsWithThisLastNameAndFirstName(String lastName, String firstName) {
		this.medicalRecords = getAllMedicalRecordsFromFile();
		for (Medicalrecords medicalrecords : medicalRecords) {
			if (medicalrecords.getFirstName().equals(firstName) && medicalrecords.getLastName().equals(lastName)) {
				return medicalrecords;
			}
		}
		return null;
	}

	@Override
	public Medicalrecords updateAMedicalrecord(Medicalrecords medicalrecords) {
		this.medicalRecords = getAllMedicalRecordsFromFile();

		Medicalrecords foundAMedicalRecord = getMdicalReocrdsWithThisLastNameAndFirstName(medicalrecords.getLastName(),
				medicalrecords.getFirstName());
		if (foundAMedicalRecord != null) {
			try {
				foundAMedicalRecord.setBirthdate(medicalrecords.getBirthdate());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			foundAMedicalRecord.setAllergies(medicalrecords.getAllergies());
			foundAMedicalRecord.setMedications(medicalrecords.getMedications());
		}
		return foundAMedicalRecord;
	}

	@Override
	public List<AllInfoFromPerson> getPersonInfo(String lastName, String firstName) {
		this.persons = getAllPersonsFromFile();
		this.medicalRecords = getAllMedicalRecordsFromFile();
		List<AllInfoFromPerson> personInfos = new ArrayList<>();

		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				AllInfoFromPerson pInfo = new AllInfoFromPerson();
				pInfo.setFirstName(person.getFirstName());
				pInfo.setLastName(person.getLastName());
				pInfo.setEmail(person.getEmail());
				for (Medicalrecords medicalrecord : medicalRecords) {
					if (medicalrecord.getFirstName().equals(firstName)
							&& medicalrecord.getLastName().equals(lastName)) {
						pInfo.setAllergies(medicalrecord.getAllergies());
						pInfo.setMedications(medicalrecord.getMedications());
					}

				}
				personInfos.add(pInfo);
			}

		}
		return personInfos;
	}

	@Override
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

		this.persons = getAllPersonsFromFile();
		this.medicalRecords = getAllMedicalRecordsFromFile();
		List<AllInfoFromPerson> enfants = new ArrayList<>();
		List<AllInfoFromPerson> adultes = new ArrayList<>();

		for (Person person : persons) {
			if (person.getAddress().equals(address)) {
				AllInfoFromPerson allInfo = new AllInfoFromPerson();
				allInfo.setLastName(person.getLastName());
				allInfo.setFirstName(person.getFirstName());

				for (Medicalrecords medicalrecord : medicalRecords) {
					if (medicalrecord.getFirstName().equals(person.getFirstName())
							&& medicalrecord.getLastName().equals(person.getLastName())) {
						int age = Utils.getAgeFromBirthdate(medicalrecord.getBirthdate());
						allInfo.setAge(age);
						if (age < 18) {
							enfants.add(allInfo);
						} else {
							adultes.add(allInfo);
						}

					}
				}
			}
		}
		ChildAlert childalert = new ChildAlert();
		childalert.setAddress(address);
		childalert.setEnfants(enfants);
		if (!enfants.isEmpty()) {
			childalert.setAdultes(adultes);
		}

		return childalert;
	}

	@Override
	public List<String> getPhoneAlert(int station) {
		this.persons = getAllPersonsFromFile();
		this.firestations = getAllFirestationsFromFile();

		List<String> phoneNumbers = new ArrayList<>();
		String address = "";
		for (Firestation firestation : firestations) {
			if (firestation.getStation() == station) {
				address = firestation.getAddress();
				for (Person person : persons) {
					if (person.getAddress().equals(address) && !phoneNumbers.contains(person.getPhone())) {
						phoneNumbers.add(person.getPhone());
					}
				}

			}

		}
		return phoneNumbers;
	}

	@Override
	public List<AllInfoFromPerson> getPersonLivingAtThisAddress(String address) {
		this.persons = getAllPersonsFromFile();
		this.firestations = getAllFirestationsFromFile();
		this.medicalRecords = getAllMedicalRecordsFromFile();

		List<AllInfoFromPerson> list = new ArrayList<>();

		for (Person person : persons) {
			if (person.getAddress().equals(address)) {
				AllInfoFromPerson allInfo = new AllInfoFromPerson();
				allInfo.setLastName(person.getLastName());
				allInfo.setFirstName(person.getFirstName());
				allInfo.setAddress(person.getAddress());
				allInfo.setPhone(person.getPhone());

				for (Firestation firestation : firestations) {
					if (person.getAddress().equals(firestation.getAddress())) {
						allInfo.setStation(firestation.getStation());
					}
				}

				for (Medicalrecords medicalrecord : medicalRecords) {
					if (medicalrecord.getFirstName().equals(person.getFirstName())
							&& medicalrecord.getLastName().equals(person.getLastName())) {
						allInfo.setAllergies(medicalrecord.getAllergies());
						allInfo.setMedications(medicalrecord.getMedications());
						allInfo.setAge(Utils.getAgeFromBirthdate(medicalrecord.getBirthdate()));
						list.add(allInfo);
					}
				}
			}
		}
		return list;
	}

	@Override
	public List<ByStationInfo> getInfoFromStationList(List<String> stationsFilter) {
		List<ByStationInfo> stationInfos = new ArrayList<>();
		for (String station : stationsFilter) {
			ByStationInfo stationInfo = new ByStationInfo();
			stationInfo.setStation(Integer.parseInt(station));
			List<String> adresses = getAdresseFromStation(Integer.parseInt(station));
			Map<String, List<AllInfoFromPerson>> personByAdresse = new HashMap<>();
			for (String adresse : adresses) {
				List<AllInfoFromPerson> personAtThisAdresse = getPersonLivingAtThisAddress(adresse);
				personByAdresse.put(adresse, personAtThisAdresse);
			}
			stationInfo.setPersonByAdresse(personByAdresse);
			stationInfos.add(stationInfo);
		}

		return stationInfos;

	}

	@Override
	public List<String> getAdresseFromStation(int stationNumber) {
		this.firestations = getAllFirestationsFromFile();
		List<String> adresses = new ArrayList<>();
		for (Firestation station : firestations) {
			if (station.getStation() == stationNumber) {
				adresses.add(station.getAddress());
			}
		}
		return adresses;
	}

	@Override
	public PeopleAtFirestation personsCoveredByAFirestation(int station) {
		this.persons = getAllPersonsFromFile();
		this.firestations = getAllFirestationsFromFile();
		this.medicalRecords = getAllMedicalRecordsFromFile();
		
		PeopleAtFirestation peopleAtFirestation = new PeopleAtFirestation();
		
		int nbrAdultes = 0;
		int nbrEnfants = 0;
		
		List<String> adresses = getAdresseFromStation(station);
		for (String adresse : adresses) {
			List<AllInfoFromPerson> personAtThisAdress = getPersonLivingAtThisAddress(adresse);
			peopleAtFirestation.getPersons().addAll(personAtThisAdress);
			for (AllInfoFromPerson allInfo : personAtThisAdress) {
				if(allInfo.getAge() > 17) {
					nbrAdultes++;
				} else {
					nbrEnfants++;
				}
			}
			
		}
		
		peopleAtFirestation.setNombreAdultes(nbrAdultes);
		peopleAtFirestation.setNombreEnfants(nbrEnfants);
		
		return peopleAtFirestation;
	}
}
