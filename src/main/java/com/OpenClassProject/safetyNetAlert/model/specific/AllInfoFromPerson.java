package com.OpenClassProject.safetyNetAlert.model.specific;

import java.util.List;
import java.util.Objects;

import com.OpenClassProject.safetyNetAlert.controller.View;
import com.fasterxml.jackson.annotation.JsonView;

public class AllInfoFromPerson {

	@JsonView(View.infoFirstName.class)
	private String firstName; //

	@JsonView(View.infoLastName.class)
	private String lastName; //
	private String city;
	private String zip;
	private String phone;
	private String email;

	@JsonView(View.infoAge.class)
	private int age; //
	private List<String> medications;
	private List<String> allergies;

	public AllInfoFromPerson(String firstName, String lastName, String city, String zip, String phone, String email,
			int age, List<String> medications, List<String> allergies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	@Override
	public int hashCode() {
		return Objects.hash(age, allergies, city, email, firstName, lastName, medications, phone, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllInfoFromPerson other = (AllInfoFromPerson) obj;
		return age == other.age && Objects.equals(allergies, other.allergies) && Objects.equals(city, other.city)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(medications, other.medications)
				&& Objects.equals(phone, other.phone) && Objects.equals(zip, other.zip);
	}

}
