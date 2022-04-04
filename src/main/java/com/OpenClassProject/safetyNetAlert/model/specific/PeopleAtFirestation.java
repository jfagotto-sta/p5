package com.OpenClassProject.safetyNetAlert.model.specific;

import java.util.ArrayList;
import java.util.List;

import com.OpenClassProject.safetyNetAlert.controller.View;
import com.fasterxml.jackson.annotation.JsonView;

@JsonView(View.viewPeopleAtFirestation.class)
public class PeopleAtFirestation {

	private int nombreAdultes;
	private int nombreEnfants;
	private List<AllInfoFromPerson> persons = new ArrayList<>();
	

	public PeopleAtFirestation() {
		
	}
	public int getNombreAdultes() {
		return nombreAdultes;
	}
	public void setNombreAdultes(int nombreAdultes) {
		this.nombreAdultes = nombreAdultes;
	}
	public int getNombreEnfants() {
		return nombreEnfants;
	}
	public void setNombreEnfants(int nombreEnfants) {
		this.nombreEnfants = nombreEnfants;
	}
	public List<AllInfoFromPerson> getPersons() {
		return persons;
	}
	public void setPersons(List<AllInfoFromPerson> persons) {
		this.persons = persons;
	}
	
	
	
}
