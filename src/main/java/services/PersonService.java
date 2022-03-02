package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.repository.IRepository;
import com.OpenClassProject.safetyNetAlert.repository.PersonRepository;

@Service
public class PersonService implements PersonRepository {
	
	private IRepository personRepo;
	
	@Autowired
	public PersonService(IRepository repo) {
		this.personRepo = repo;
	}
	
	public List<Person> getAll() {
		return personRepo.getAllPersonsFromFile();
	}

	@Override
	public Person createANewPerson(Person person) {
		return personRepo.createAPerson(person);
	}

	@Override
	public void deleteAPerson(String lastName, String firstName) {
//		Person person = new Person();
//		person.setLastName(lastName);
//		person.setFirstName(firstName);
		//???
		personRepo.deleteAPerson(lastName, firstName);
	}

	@Override
	public Person updateAPerson(Person person) {
		return personRepo.updateAPerson(person);
		
	}
	
}
