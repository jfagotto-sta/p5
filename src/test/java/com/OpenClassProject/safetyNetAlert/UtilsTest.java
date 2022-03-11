package com.OpenClassProject.safetyNetAlert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.OpenClassProject.safetyNetAlert.utils.Utils;

import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;



class UtilsTest {

	@Test
	void testAgeMethod() throws ParseException {
		
		Medicalrecords medicalrecords= new Medicalrecords();
		
		medicalrecords.setBirthdate("09/06/2000");
		int age = Utils.getAgeFromBirthdate(medicalrecords.getBirthdate());

		assertEquals(22, age);
	}

}
