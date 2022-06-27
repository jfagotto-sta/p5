package com.OpenClassProject.safetyNetAlert;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FirestationControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	
	
	@Test
	void getMappingForAFirestation() throws Exception {
		
		mockMvc.perform(get("/firestations")).andExpect(status().isOk());
	}
	
	@Test
	void postMappingForAFirestation() throws Exception {
		
		Firestation firestation = new Firestation();
		firestation.setAddress("Rue de paris");
		firestation.setStation(2);
		
		ObjectMapper mapper = new ObjectMapper();
		String f = mapper.writeValueAsString(firestation);
		
		mockMvc.perform(post("/firestations").contentType(MediaType.APPLICATION_JSON_VALUE).content(f)).andExpect(status().isOk());
	}
	
	@Test
	public void PutMappingForAFirestation() throws Exception {
		
		Firestation firestation = new Firestation();
		firestation.setAddress("Rue de paris");
		firestation.setStation(1);
		
		ObjectMapper obj =new ObjectMapper();
		String f = obj.writeValueAsString(firestation);
		
		mockMvc.perform(put("/firestations").contentType(MediaType.APPLICATION_JSON_VALUE).content(f)).andExpect(status().isOk());
		
	}
	
	@Test
	public void deleteMappingForAFirestation() throws Exception {
		
		Firestation firestation = new Firestation();
		firestation.setAddress("Rue de paris");
		firestation.setStation(1);
		
		ObjectMapper obj =new ObjectMapper();
		String f = obj.writeValueAsString(firestation);
		
		mockMvc.perform(delete("/firestations").contentType(MediaType.APPLICATION_JSON_VALUE).content(f)).andExpect(status().isOk());
	}

	@Test
	void phonaAlert() throws Exception {

		mockMvc.perform(get("/phoneAlert").param("station","1"))
				.andExpect(status().isOk());

	}

	@Test
	void floodAlert() throws Exception {

		mockMvc.perform(get("/flood").param("stations","1"))
				.andExpect(status().isOk());

	}
	@Test
	void personCovered() throws Exception {

		mockMvc.perform(get("/firestation").param("stationNumber","1"))
				.andExpect(status().isOk());

	}

}
