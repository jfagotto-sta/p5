package com.OpenClassProject.safetyNetAlert.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Firestation;

@Repository
public interface FireStationRepository {
	
	public List<Firestation> getAllFirestations();

}
