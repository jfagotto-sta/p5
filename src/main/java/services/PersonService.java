package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.repository.IRepository;
import com.OpenClassProject.safetyNetAlert.repository.personRepository;

public class PersonService implements personRepository {
	
	private IRepository personRepo;
	
	@Autowired
	public PersonService(IRepository repo) {
		this.personRepo = repo;
	}
	
	public List<Person> getAll() {
		return personRepo.getAllPersonsFromFile();
	}
	
	public Person getInfo (String lastName, String firstName) {
		return null;
	}
	public Person findAPersonWithHisLastNameAndFirstName(String lastName, String firstName) {
		return new Person(lastName,firstName, "adress", "phone", "Mail", "phone", "mail");
	
	}	
	
}
