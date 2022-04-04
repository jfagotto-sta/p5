package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.specific.ByStationInfo;
import com.OpenClassProject.safetyNetAlert.model.specific.PeopleAtFirestation;
import com.OpenClassProject.safetyNetAlert.repository.IRepository;

@Service
public class FireStationService implements services.ServiceInterface.IFireStationService {

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

	public Firestation createAMappingFirestationAdress(Firestation firestation) {
		return fireStationRepo.createAMappingFirestationAdress(firestation);
	}

	public boolean deleteAFirestation(Firestation firestation) {
		return fireStationRepo.deleteAFirestation(firestation);
	}

	public Firestation updateAFirestation(Firestation firestation) {
		return fireStationRepo.updateAFirestation(firestation);
	}

	@Override
	public List<String> getPhoneAlert(int station) {
		return fireStationRepo.getPhoneAlert(station);
	}

	@Override
	public List<ByStationInfo> getInfoFromStationList(List<String> stations) {
		return fireStationRepo.getInfoFromStationList(stations);
	}

	@Override
	public PeopleAtFirestation personsCoveredByAFirestation(int station) {
		return fireStationRepo.personsCoveredByAFirestation(station);
	}

}
