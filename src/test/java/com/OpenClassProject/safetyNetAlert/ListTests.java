package com.OpenClassProject.safetyNetAlert;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.repository.JsonFileRepository;


 
@SpringBootTest
class ListTests {
	
	@Autowired
	private JsonFileRepository JsfRepo;
	
	private List<Person> persons = new ArrayList<>();
	private List<Firestation> firestations = new ArrayList<>();
	private List<Medicalrecords> medicalRecords = new ArrayList<>();


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@DisplayName("Test pour vérifier l'initialisation de la liste de personnes")
	@Test
	public void testListOfPerson() {
		persons = JsfRepo.getAllPersonsFromFile();
		
		assertTrue(persons.size()>0);
	}
	
	@DisplayName("Test pour vérifier l'initialisation de la liste de casernes")
	@Test
	public void testListOfFirestation() {
		firestations = JsfRepo.getAllFirestationsFromFile();
		
		assertTrue(firestations.size()>0);
	}
	
	@DisplayName("Test pour vérifier l'initialisation de la liste de profils médicamenteux")
	@Test
	public void testListOfMedicalrecord() {
		medicalRecords = JsfRepo.getAllMedicalRecordsFromFile();
		
		assertTrue(medicalRecords.size()>0);
	}

}
