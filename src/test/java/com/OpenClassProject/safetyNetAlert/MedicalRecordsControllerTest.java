package com.OpenClassProject.safetyNetAlert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.OpenClassProject.safetyNetAlert.controller.MedicalRecordsController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.repository.JsonFileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class MedicalRecordsControllerTest {

	private List<Medicalrecords> medicalrecords = new ArrayList<>();
	
	@Autowired
	public MockMvc mockMvc;
	
	@Autowired
	JsonFileRepository jRepo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		medicalrecords = jRepo.getAllMedicalRecordsFromFile();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	void getMappingForAMedicalrecords() throws Exception {

		mockMvc.perform(get("/medicalrecords")).andExpect(status().isOk());
	}


	@Test
	void deleteAMedicalrecord() throws Exception {

		mockMvc.perform(delete("/medicalrecords").contentType(MediaType.APPLICATION_JSON_VALUE)
				.param("firstName", "John").param("lastName", "Boyd")).andExpect(status().isOk());

	}


}
