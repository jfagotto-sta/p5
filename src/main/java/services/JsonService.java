package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.repository.IRepository;

@Service
public class JsonService {

	private IRepository repository;
	
	@Autowired
	public JsonService(final IRepository repository) {
		this.repository = repository;
	}
	


	public List<Person> getAllPersonsFromFile() {
		return repository.getAllPersonsFromFile();
		
	}
	
	public List<Firestation> getAllFirestationsFromFile() {
		return repository.getAllFirestationsFromFile();
		
	}
	
	public List<Medicalrecords> getAllMedicalRecordsFromFile() {
		return repository.getAllMedicalRecordsFromFile();
		
	}

	
}
