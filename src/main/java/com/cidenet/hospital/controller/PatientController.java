package com.cidenet.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.hospital.model.Patient;
import com.cidenet.hospital.repository.PatientRepository;

/**
 * PatientController class
 * @author jsepulveda
 * @since April 2020
 */
@RestController
@RequestMapping("/api/v1")
public class PatientController {
	
	/**
	 * patientRepository field
	 */
	@Autowired
	private PatientRepository patientRepository;
	
	
	/**
	 * Get all registered patients
	 * @return list of patients
	 */
	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	
	/**
	 * Create a patient and if successful return it
	 * @param patient
	 * @return patient
	 */
	@PostMapping("/patient")
	public Patient createPatient(@Valid @RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	/**
	 * Deletes a specific patient
	 * @param patientId
	 * @return action status
	 */
	@DeleteMapping("/patient/{id}")
	public Map<String, Boolean> deletePatient(@PathVariable(value = "id") Long patientId) {
		
		try {
			patientRepository.deleteById(patientId);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
		
			return response;
		
		} catch (Exception e) {
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.FALSE);
		
			return response;
		}
	}
	
	/**
	 * Get a patient with a specific id
	 * @param patientId
	 * @return a patient
	 */
	@GetMapping("patient/{id}")
	public ResponseEntity<Optional<Patient>> getPatientById(@PathVariable(value = "id") Long patientId) {
		Optional<Patient> patient = patientRepository.findById(patientId);
		return ResponseEntity.ok().body(patient);
	}
	
	/**
	 * Update patient
	 * @param patientId
	 * @param patientDetails
	 * @return patient updated
	 */
	@PutMapping("patient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Long patientId, @Valid @RequestBody Patient patientDetails) {
		Patient patient = patientRepository.findById(patientId).get();
		
		patient.setId(patientDetails.getId());
		patient.setFirstName(patientDetails.getFirstName());
		patient.setLastName(patientDetails.getLastName());
		patient.setEmail(patientDetails.getEmail());
		patient.setPhone(patientDetails.getPhone());
		Patient updatedPatient = patientRepository.save(patient);
		
		return ResponseEntity.ok().body(updatedPatient);
	}
}
