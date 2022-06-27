package com.OpenClassProject.safetyNetAlert;


import com.OpenClassProject.safetyNetAlert.repository.IRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.repository.JsonFileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import services.PersonService;


@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {
	
	private List<Person> persons = new ArrayList<>();

	@Autowired
	private IRepository iRepo;

	@Autowired
	public MockMvc mockMvc;
	
	@MockBean
	private PersonService personService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		persons = iRepo.getAllPersonsFromFile();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	
	@Test
	 void createAPersonTest() throws Exception {
		
		Person person = new Person();
		person.setAddress("10 rue de paris");
		person.setCity("Paris");
		person.setEmail("test@mail.com");
		person.setFirstName("Illidan");
		person.setLastName("Hurlorage");
		person.setPhone("555-000-5555");
		person.setZip("55555");
		
		ObjectMapper obj =new ObjectMapper();
		String p = obj.writeValueAsString(person);
		
		mockMvc.perform(post("/persons").contentType(MediaType.APPLICATION_JSON_VALUE).content(p))
		.andExpect(status().isOk());
	}
	
	
	@Test
	 void putPersonTest() throws Exception {
		
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
		
		ObjectMapper obj =new ObjectMapper();
		String p2 = obj.writeValueAsString(person2);
		persons.add(person);
		
		Person foundAPersonToUpdate = iRepo.getPersonWithThisLastNameAndFirstName("Hurlorage", "Illidan");
		
		personService.updateAPerson(foundAPersonToUpdate);
		
		mockMvc.perform(put("/persons").contentType(MediaType.APPLICATION_JSON_VALUE).content(p2))
		.andExpect(status().isOk());
		
		assertTrue(person.getEmail().equals(foundAPersonToUpdate.getEmail()));
		
	}
	
	@Test
	 void deleteAPerson() throws Exception {
		
		mockMvc.perform(delete("/persons").param("firstName", "John").param("lastName", "Boyd"))
				.andExpect(status().isOk());
	}
	
	@Test
	 void getAPerson() throws Exception {
		
		mockMvc.perform(get("/personInfo").param("firstName", "John").param("lastName", "Boyd"))
		.andExpect(status().isOk());
	}

	@Test
	void personInfos() throws Exception {

		mockMvc.perform(get("/personInfo").param("firstName","john").param("lastName","Boyd"))
				.andExpect(status().isOk());

	}

	@Test
	void childAlert() throws Exception {


		mockMvc.perform(get("/childAlert").param("address","1509 Culver St"))
				.andExpect(status().isOk());
	}
	@Test
	void personLivingAtThisAddress() throws Exception {

		mockMvc.perform(get("/fire").param("address","1509 Culver St"))
				.andExpect(status().isOk());

	}


}
