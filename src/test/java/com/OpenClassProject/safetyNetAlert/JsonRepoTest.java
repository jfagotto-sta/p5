package com.OpenClassProject.safetyNetAlert;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.OpenClassProject.safetyNetAlert.repository.IRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.model.specific.AllInfoFromPerson;
import com.OpenClassProject.safetyNetAlert.model.specific.ByStationInfo;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import com.OpenClassProject.safetyNetAlert.model.specific.PeopleAtFirestation;
import com.OpenClassProject.safetyNetAlert.repository.JsonFileRepository;

@SpringBootTest
class JsonRepoTest {
	
	private List<Person> persons = new ArrayList<>();
	private List<Firestation> firestations = new ArrayList<>();
	private List<Medicalrecords> medicalRecords = new ArrayList<>();
	

	@Autowired
	private IRepository iRepo;
	


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		this.persons= iRepo.getAllPersonsFromFile();

	}

	@AfterEach
	void tearDown() throws Exception {
		persons.clear();;

	}

	@Test
	void getAPersonWithHisLastNameAndFirstName () {
			
		Person p = iRepo.getPersonWithThisLastNameAndFirstName("Boyd", "John");
		
		assertTrue(p.getCity().equals("Culver"));
		
		
	}
	
	@Test
	void getPersonInfo() {
		
		List<AllInfoFromPerson> p = iRepo.getPersonInfo("Boyd", "John");
		
		
		assertEquals(p.size(),1);
		
	}
	
	@Test
	void getMailAddressesForACity() {
		
		List<String> mail = iRepo.getMailAddressesForACity("Culver");
		assertEquals(mail.size(),23);
	}
	
	@Test
	void getChildAlert() {
		
		ChildAlert ca = new ChildAlert();
		
		ca = iRepo.getChildAlert("947 E. Rose Dr");
		
		assertNotNull(ca);
	}
	
	@Test
	void getPhoneAlert() {

		List<String> phoneNumber = iRepo.getPhoneAlert(1);
		
		assertNotNull(phoneNumber);
	}
	
	@Test
	void getMdicalReocrdsWithThisLastNameAndFirstName() {
		Medicalrecords m = new Medicalrecords();
				
				iRepo.getMdicalReocrdsWithThisLastNameAndFirstName("Boyd", "John");
		
		assertNotNull(m);
	}
	
	@Test
	void getPersonLivingAtThisAddress() {
		
		List<AllInfoFromPerson> list = new ArrayList<>();
		
		list = iRepo.getPersonLivingAtThisAddress("947 E. Rose Dr");
		
		assertEquals(list.size(),3);
	}
	
	@Test
	void getAdresseFromStation() {
		
		List<String> adresses = iRepo.getAdresseFromStation(1);
		assertEquals(adresses.size(),3);
	}
	
	@Test
	void personCoveredByFirestation() {
		
		
		PeopleAtFirestation adresses = new PeopleAtFirestation();
		
		adresses = iRepo.personsCoveredByAFirestation(1);
		
		assertNotNull(adresses);
	}
	
	@Test
	 void getInfoFromationList() {
	
		List<ByStationInfo> bS = new ArrayList<ByStationInfo>();
		List<String> stationsFilter = new ArrayList<String>();
		stationsFilter.add("1");
		stationsFilter.add("2");
		bS = iRepo.getInfoFromStationList(stationsFilter);
		
		assertNotNull(bS);
	}
}
