package services.ServiceInterface;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import org.springframework.stereotype.Service;

@Service
public interface IMedicalRecordsService {
	
	public List<Medicalrecords> getAllMedicalRecords();
	
	public Medicalrecords createAMedicalRecord(Medicalrecords medicalrecords);
	
	public boolean deleteAMedicalrecord(String lastName, String firstName);
	
	public Medicalrecords updateAMedicalrecord (Medicalrecords medicalrecords);

}
