package com.OpenClassProject.safetyNetAlert.repository;

import java.util.List;
import java.util.Map;

import com.OpenClassProject.safetyNetAlert.model.Firestation;
import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;
import com.OpenClassProject.safetyNetAlert.model.Person;
import com.OpenClassProject.safetyNetAlert.model.specific.AllInfoFromPerson;
import com.OpenClassProject.safetyNetAlert.model.specific.ByStationInfo;
import com.OpenClassProject.safetyNetAlert.model.specific.ChildAlert;
import com.OpenClassProject.safetyNetAlert.model.specific.PeopleAtFirestation;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository {
	
	public List<Person> getAllPersonsFromFile();
	
	public List<Firestation> getAllFirestationsFromFile();
	
	public List<Medicalrecords> getAllMedicalRecordsFromFile();
	
	public void deleteAPerson(String lastName, String firstName);
	
	public Person createAPerson (Person person);

	Person getPersonWithThisLastNameAndFirstName(String lastName, String firstName);

	Firestation getFirestation(String addres);

	public Person updateAPerson (Person person);
	
	public Firestation createAMappingFirestationAdress(Firestation firestation);
	
	public boolean deleteAFirestation(Firestation firestation);
	
	public Firestation updateAFirestation (Firestation firestation);
	
	public Medicalrecords createAMedicalRecord(Medicalrecords medicalrecords);
	
	public boolean deleteAMedicalrecord(String lastName, String firstName);

	Medicalrecords getMdicalReocrdsWithThisLastNameAndFirstName(String lastName, String firstName);

	public Medicalrecords updateAMedicalrecord (Medicalrecords medicalrecords);

	public List<AllInfoFromPerson> getPersonInfo(String lastName, String firstName);

	List<String> getMailAddressesForACity(String city);

	public ChildAlert getChildAlert(String address);

	public List<String> getPhoneAlert(int station);

	public List<AllInfoFromPerson> getPersonLivingAtThisAddress(String address);
	
	public List<ByStationInfo> getInfoFromStationList(List<String> stations);

	List<String> getAdresseFromStation(int stationNumber);

	public PeopleAtFirestation personsCoveredByAFirestation(int station);
}
