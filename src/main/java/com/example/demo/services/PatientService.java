package com.example.demo.services;

import com.example.demo.entities.Patient;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface PatientService {
    Collection<Patient> findAllObjects();

    Patient getOneObject(Integer id);

    Collection<Patient> findByWard(Integer ward);

    ResponseEntity<Patient> create(Patient patient);

    ResponseEntity<Patient> delete(Integer id);

    ResponseEntity<Patient> update(Patient patient);
}
