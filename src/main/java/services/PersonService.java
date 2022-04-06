package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.model.specific.AllInfoFromPerson;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import com.OpenClassProject.safetyNetAlert.repository.IRepository;

@Service
public class PersonService implements services.ServiceInterface.IPersonService {
	
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
	@Override
	public List<AllInfoFromPerson> personInfo(String lastName, String firstName) {
		return personRepo.getPersonInfo(lastName, firstName);
	}
	@Override
	public ChildAlert getChildAlert(String address) {
		return personRepo.getChildAlert(address);
	}

	@Override
	public List<AllInfoFromPerson> getPersonLivingInThisAddress(String address) {
		return personRepo.getPersonLivingAtThisAddress(address);
	}
	
}
