package com.OpenClassProject.safetyNetAlert.model.specific;

import java.util.List;
import java.util.Objects;

import com.OpenClassProject.safetyNetAlert.controller.View;
import com.fasterxml.jackson.annotation.JsonView;

@JsonView(View.viewChildAlert.class)
public class ChildAlert {

	private String address;
	private List<AllInfoFromPerson> enfants;
	private List<AllInfoFromPerson> adultes;

	public ChildAlert(String address, List<AllInfoFromPerson> enfants, List<AllInfoFromPerson> adultes) {
		super();
		this.address = address;
		this.enfants = enfants;
		this.adultes = adultes;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<AllInfoFromPerson> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<AllInfoFromPerson> enfants) {
		this.enfants = enfants;
	}

	public List<AllInfoFromPerson> getAdultes() {
		return adultes;
	}

	public void setAdultes(List<AllInfoFromPerson> adultes) {
		this.adultes = adultes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, adultes, enfants);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChildAlert other = (ChildAlert) obj;
		return Objects.equals(address, other.address) && Objects.equals(adultes, other.adultes)
				&& Objects.equals(enfants, other.enfants);
	}

}
