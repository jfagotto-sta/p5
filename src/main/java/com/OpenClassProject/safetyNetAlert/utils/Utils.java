package com.OpenClassProject.safetyNetAlert.utils;

import java.util.Calendar;
import java.util.Date;

public class Utils {

	
	public static int getAgeFromBirthdate(Date dateOfBirth) {
		
		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();
		
		birthDate.setTime(dateOfBirth);
		
		int age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
		
		if ((today.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH)) || 
				(today.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH)) ) {
			age--;
		}	
		return age;
	}	
}
