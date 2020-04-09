package com.cidenet.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cidenet.hospital.model.Patient;

/**
 * PatientRepository Interface
 * @author jsepulveda
 * @since April 2020
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
