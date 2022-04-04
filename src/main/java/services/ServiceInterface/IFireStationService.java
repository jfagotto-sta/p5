package services.ServiceInterface;

import java.util.List;

import com.OpenClassProject.safetyNetAlert.model.specific.ByStationInfo;
import com.OpenClassProject.safetyNetAlert.model.specific.PeopleAtFirestation;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import org.springframework.stereotype.Service;

@Service
public interface IFireStationService {
	
	public List<Firestation> getAllFirestations();
	
	public Firestation createAMappingFirestationAdress(Firestation firestation);
	
	public boolean deleteAFirestation(Firestation firestation);
	
	public Firestation updateAFirestation (Firestation firestation);

	public List<String> getPhoneAlert(int station);

	public List<ByStationInfo> getInfoFromStationList(List<String> stations);

	public PeopleAtFirestation personsCoveredByAFirestation(int station);


}
