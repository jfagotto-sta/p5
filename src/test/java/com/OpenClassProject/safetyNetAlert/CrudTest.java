package com.OpenClassProject.safetyNetAlert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.OpenClassProject.safetyNetAlert.repository.IRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.repository.JsonFileRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import services.ServiceInterface.IFireStationService;
import services.ServiceInterface.IMedicalRecordsService;
import services.ServiceInterface.IPersonService;


@SpringBootTest
class CrudTest {


	private List<Person> persons = new ArrayList<>();
	private List<Firestation> firestations = new ArrayList<>();
	private List<Medicalrecords> medicalrecords = new ArrayList<>();

	@Autowired
	private IRepository iRepo;


	@Autowired
	private IPersonService pService;

	@Autowired
	private IMedicalRecordsService mService;

	@Autowired
	private IFireStationService fService;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		this.persons = iRepo.getAllPersonsFromFile();
		this.firestations = iRepo.getAllFirestationsFromFile();
		this.medicalrecords = iRepo.getAllMedicalRecordsFromFile();

	}

	@AfterEach
	void tearDown() throws Exception {
		persons.clear();
		firestations.clear();
		medicalrecords.clear();

	}


	@Test
	void createAPerson() {

		Person person = new Person();

		int listOfPersonBeforeTheCreation = persons.size();

		pService.createANewPerson(person);


		assertEquals(listOfPersonBeforeTheCreation + 1, persons.size());

	}

	@Test
	void deleteAPerson() {

		int listOfPersonBeforeTheDelete = persons.size();

		pService.deleteAPerson("Boyd", "John");

		assertEquals(listOfPersonBeforeTheDelete - 1, persons.size());

	}

	@Test
	void updateAPerson() throws JsonProcessingException {

		Person person = new Person();
		person.setAddress("10 rue de paris");
		person.setCity("Paris");
		person.setEmail("test@mail.com");
		person.setFirstName("Illidan");
		person.setLastName("Hurlorage");
		person.setPhone("555-000-5555");
		person.setZip("55555");

		Person person2 = new Person();
		person2.setAddress("10 rue de paris");
		person2.setCity("Paris");
		person2.setEmail("test2@mail.com");
		person2.setFirstName("Illidan");
		person2.setLastName("Hurlorage");
		person2.setPhone("555-000-5555");
		person2.setZip("55555");

		persons.add(person);

		Person foundAPersonToUpdate = pService.updateAPerson(person2);
		assertTrue(person.getEmail().equals(foundAPersonToUpdate.getEmail()));

	}

	@Test
	void createAMedicalRecord() {


		List<String> listMedications = new ArrayList<>();
		List<String> listAllergies = new ArrayList<>();
		Medicalrecords medicalrecord = new Medicalrecords();
		medicalrecord.setFirstName("fag");
		medicalrecord.setLastName("fagotto");
		try {
			medicalrecord.setBirthdate("18/07/1993");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		medicalrecord.setMedications(listMedications);
		medicalrecord.setAllergies(listAllergies);

		int listSizeBeforeTheCreation = medicalrecords.size();

		mService.createAMedicalRecord(medicalrecord);

		assertEquals(medicalrecords.size(), listSizeBeforeTheCreation + 1);
	}

	@Test
	void updateAMedicalrecord() throws Exception {

		List<String> listMedications = new ArrayList<>();
		List<String> listAllergies = new ArrayList<>();

		listMedications.add("Paracetamol");
		listAllergies.add("Paracetamol");

		Medicalrecords medicalrecords1 = new Medicalrecords();
		medicalrecords1.setFirstName("fag");
		medicalrecords1.setLastName("fagotto");
		medicalrecords1.setBirthdate("18/07/1993");
		medicalrecords1.setMedications(listMedications);
		medicalrecords1.setAllergies(listAllergies);

		Medicalrecords medicalrecords2 = new Medicalrecords();
		medicalrecords2.setFirstName("fag");
		medicalrecords2.setLastName("fagotto");
		medicalrecords2.setBirthdate("18/18/2018");
		medicalrecords2.setMedications(listMedications);
		medicalrecords2.setAllergies(listAllergies);


		medicalrecords.add(medicalrecords1);

		Medicalrecords foundAMedicalRecord = mService.updateAMedicalrecord(medicalrecords2);

		assertTrue(foundAMedicalRecord.getBirthdate().equals(medicalrecords2.getBirthdate()));

	}

	@Test
	void deleteAMedicalrecord() {

		int listSizeBeforeTheDeletion = medicalrecords.size();

		mService.deleteAMedicalrecord("Boyd", "John");

		assertEquals(listSizeBeforeTheDeletion - 1, medicalrecords.size());

	}

	@Test
	void createAFirestation() {
		Firestation firestation = new Firestation();

		int listSizeBeforeCreation = firestations.size();

		fService.createAMappingFirestationAdress(firestation);

		assertEquals(listSizeBeforeCreation + 1, firestations.size());

	}

	@Test
	void deleteAFirestation() {

		Firestation firestation = new Firestation();

		int listOfFirestationsBeforeDeletion = firestations.size();
		firestations.add(firestation);

		fService.deleteAFirestation(firestation);

		assertEquals(listOfFirestationsBeforeDeletion, firestations.size());
	}

	@Test
	void updateAFirestation() {

		Firestation firestation = new Firestation();
		firestation.setStation(1);
		firestation.setAddress("rue des champs");

		firestations.add(firestation);



		Firestation foundAFirestationToUpdate = fService.updateAFirestation(iRepo.getFirestation("rue des champs"));

		assertNotNull(foundAFirestationToUpdate);
	}

}
