package com.OpenClassProject.safetyNetAlert.model.specific;

import java.util.List;

public class PersonInfo {
	
	private String lastName;
	private String firstName;
	private String email;	
	private List<String> medications;
	private List<String> allergies;
	
	
	public PersonInfo(String lastName, String firstName, 
			String email, List<String> medications, List<String> allergies) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		
		this.email = email;
		this.medications = medications;
		this.allergies = allergies;
	}


	public PersonInfo() {
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<String> getMedications() {
		return medications;
	}


	public void setMedications(List<String> medications) {
		this.medications = medications;
	}


	public List<String> getAllergies() {
		return allergies;
	}


	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	

}
