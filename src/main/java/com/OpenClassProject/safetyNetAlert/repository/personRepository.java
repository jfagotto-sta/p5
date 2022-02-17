package com.OpenClassProject.safetyNetAlert.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Person;

@Repository
public interface personRepository {
	
	public List<Person> getAll();
	
	//public List<Person> findAPersonWithHisName(String firstName, String lastName);
	
	public Person findAPersonWithHisLastNameAndFirstName(String lastName, String firstName);

}
