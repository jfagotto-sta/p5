package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.repository.IRepository;
import com.OpenClassProject.safetyNetAlert.repository.MedicalRecordsRepository;

public class MedicalRecordsService implements MedicalRecordsRepository {

	private IRepository medicalRep;
	
	
	@Autowired
	public MedicalRecordsService(IRepository medicalRep) {
		super();
		this.medicalRep = medicalRep;
	}



	@Override
	public List<Medicalrecords> getAllMedicalRecords() {
		return medicalRep.getAllMedicalRecordsFromFile();
	}

}
