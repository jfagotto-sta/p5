package services.ServiceInterface;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Person;
import org.springframework.stereotype.Service;

@Service
public interface IPersonService {
	
	public List<Person> getAll();
	
	public Person createANewPerson(Person person);
	
	public void deleteAPerson(String lastName, String firstName);
	
	public Person updateAPerson(Person person);

	

}
