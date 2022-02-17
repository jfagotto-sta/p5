package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.repository.FireStationRepository;
import com.OpenClassProject.safetyNetAlert.repository.IRepository;

public class FireStationService implements FireStationRepository {

	
	private IRepository fireStationRepo;
	
	
	@Autowired
	public FireStationService(IRepository fireStationRepo) {
		super();
		this.fireStationRepo = fireStationRepo;
	}


	@Override
	public List<Firestation> getAllFirestations() {
		return fireStationRepo.getAllFirestationsFromFile();
	}


}
