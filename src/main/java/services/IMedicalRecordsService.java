package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.repository.IRepository;

@Service
public class IMedicalRecordsService implements services.ServiceInterface.IMedicalRecordsService {

	private IRepository medicalRep;
	
	
	@Autowired
	public IMedicalRecordsService(IRepository medicalRep) {
		super();
		this.medicalRep = medicalRep;
	}



	@Override
	public List<Medicalrecords> getAllMedicalRecords() {
		return medicalRep.getAllMedicalRecordsFromFile();
	}
	
	@Override
	public Medicalrecords createAMedicalRecord(Medicalrecords medicalrecords){
		return medicalRep.createAMedicalRecord(medicalrecords);
	}
	
	@Override
	public boolean deleteAMedicalrecord(String lastName, String firstName){
		return medicalRep.deleteAMedicalrecord(lastName, firstName);
	}
	
	@Override
	public Medicalrecords updateAMedicalrecord (Medicalrecords medicalrecords){
		return medicalRep.updateAMedicalrecord(medicalrecords);
	}

}
