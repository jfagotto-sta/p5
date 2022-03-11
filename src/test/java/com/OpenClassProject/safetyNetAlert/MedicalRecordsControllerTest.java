package com.OpenClassProject.safetyNetAlert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class MedicalRecordsControllerTest {
	
	@Autowired
	MockMvc mockMvc;

	
	

	@Test
	void getMappingForAMedicalrecords() throws Exception {
		
		mockMvc.perform(get("/medicalrecords")).andExpect(status().isOk());
	}
	
	@Test
	void postMappingForAMedicalrecord() throws Exception {
		
		Medicalrecords medicalrecords = new Medicalrecords();
		medicalrecords.setAllergies(null);
		medicalrecords.setBirthdate(null);
		medicalrecords.setFirstName(null);
		medicalrecords.setLastName(null);
		medicalrecords.setMedications(null);
		
		ObjectMapper mapper = new ObjectMapper();
		String m = mapper.writeValueAsString(medicalrecords);
		
		mockMvc.perform(post("/medicalrecords").contentType(MediaType.APPLICATION_JSON_VALUE).content(m)).andExpect(status().isOk());
	}
	
	@Test
	public void PutMappingForAMedicalrecord() throws Exception {
		
		Medicalrecords medicalrecords = new Medicalrecords();
		medicalrecords.setAllergies(null);
		medicalrecords.setBirthdate(null);
		medicalrecords.setFirstName(null);
		medicalrecords.setLastName(null);
		medicalrecords.setMedications(null);
		
		ObjectMapper obj =new ObjectMapper();
		String m = obj.writeValueAsString(medicalrecords);
		
		mockMvc.perform(put("/medicalrecords").contentType(MediaType.APPLICATION_JSON_VALUE).content(m)).andExpect(status().isOk());
		
	}
	
	@Test
	public void deleteMappingForAFirestation() throws Exception {
		
	
		mockMvc.perform(delete("/medicalrecords").contentType(MediaType.APPLICATION_JSON_VALUE).param("firstName","John" ).param("lastName", "Boyd")).andExpect(status().isOk());
		
		
	}


	
}
