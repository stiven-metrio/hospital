package com.cidenet.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
