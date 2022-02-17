package com.OpenClassProject.safetyNetAlert.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.OpenClassProject.safetyNetAlert.model.Medicalrecords;

@Repository
public interface MedicalRecordsRepository {
	
	public List<Medicalrecords> getAllMedicalRecords();

}