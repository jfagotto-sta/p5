package model;

import java.util.List;

public class Medicalrecords {
	
	private List<String> medications;
	private List<String> allergies;
	
	public Medicalrecords(List<String> medications, List<String> allergies) {
		super();
		this.medications = medications;
		this.allergies = allergies;
	}

	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	
	
}