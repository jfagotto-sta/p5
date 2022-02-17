package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.repository.IRepository;
import com.OpenClassProject.safetyNetAlert.repository.PersonRepository;

public class PersonService implements PersonRepository {
	
	private IRepository personRepo;
	
	@Autowired
	public PersonService(IRepository repo) {
		this.personRepo = repo;
	}
	
	public List<Person> getAll() {
		return personRepo.getAllPersonsFromFile();
	}
	
}
