package com.OpenClassProject.safetyNetAlert.model.specific;

import java.util.List;
import java.util.Map;

import com.OpenClassProject.safetyNetAlert.controller.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.OpenClassProject.safetyNetAlert.model.*;


@JsonView(View.viewFloodStationInfo.class)
public class ByStationInfo {
	private int station;
	private Map<String, List<AllInfoFromPerson>> personByAdresse;

	public ByStationInfo() {

	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	public Map<String, List<AllInfoFromPerson>> getPersonByAdresse() {
		return personByAdresse;
	}

	public void setPersonByAdresse(Map<String, List<AllInfoFromPerson>> personByAdresse) {
		this.personByAdresse = personByAdresse;
	}

}
