package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import com.OpenClassProject.safetyNetAlert.model.specific.PersonInfo;
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
		personRepo.deleteAPerson(lastName, firstName);
	}

	@Override
	public Person updateAPerson(Person person) {
		return personRepo.updateAPerson(person);
		
	}

	public PersonInfo personInfo(String lastName, String firstName) {
		return personRepo.getPersonInfo(lastName, firstName);
	}
	
	public ChildAlert getChildAlert(String address) {
		return personRepo.getChildAlert(address);
	}
	
}
