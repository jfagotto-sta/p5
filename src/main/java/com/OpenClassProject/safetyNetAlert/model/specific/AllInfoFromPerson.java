package com.OpenClassProject.safetyNetAlert.model.specific;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	@JsonView(View.infoAddress.class)
	private String address;
	
	@JsonView(View.infoStation.class)
	private int station;
	
	@JsonView(View.infoPhone.class)
	private String phone;
	
	@JsonView(View.infoMail.class)
	private String email;
	private Date birthdate;

	@JsonView(View.infoAge.class)
	private int age; //
	
	@JsonView(View.infoMedications.class)
	private List<String> medications;
	
	@JsonView(View.infoAllergies.class)
	private List<String> allergies;

	
	
	public AllInfoFromPerson() {
		
	}
	
	public AllInfoFromPerson(String firstName, String lastName, String city, String zip, String phone, String email,
			int age, List<String> medications, List<String> allergies, Date birthdate, String address, int station) {
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
		this.birthdate = birthdate;
		this.address = address;
		this.station = station;

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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) throws ParseException {
		this.birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

}
