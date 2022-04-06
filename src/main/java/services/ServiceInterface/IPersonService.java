package services.ServiceInterface;

import java.util.List;

import com.OpenClassProject.safetyNetAlert.model.specific.AllInfoFromPerson;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Person;
import org.springframework.stereotype.Service;

@Service
public interface IPersonService {
	
	public List<Person> getAll();
	
	public Person createANewPerson(Person person);
	
	public void deleteAPerson(String lastName, String firstName);
	
	public Person updateAPerson(Person person);

	public List<AllInfoFromPerson> personInfo(String lastName, String firstName);

	public ChildAlert getChildAlert(String address);

	public List<AllInfoFromPerson> getPersonLivingInThisAddress(String address);

	

}
