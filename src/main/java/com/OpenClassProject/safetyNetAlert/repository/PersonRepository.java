package com.OpenClassProject.safetyNetAlert.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Person;

@Repository
public interface PersonRepository {
	
	public List<Person> getAll();
	
	public Person createANewPerson(Person person);
	
	public void deleteAPerson(String lastName, String firstName);
	
	public Person updateAPerson(Person person);

	

}
