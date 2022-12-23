package com.example.demo.impl;

import com.example.demo.entities.Patient;
import com.example.demo.repository.IPatientRepository;
import com.example.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Service
public class PatientServiceImplem implements PatientService {

    @Autowired
    private IPatientRepository patientRepository;

    RestTemplate restTemplate = new RestTemplate();
    String restURI = "http://localhost:8080/ward"; //stavi u wardu da je localhost:8080
    @Override
    public Collection<Patient> findAllObjects() {
        return patientRepository.findAll();
    }



    @Override
    public Patient getOneObject(Integer id) {
        return patientRepository.getById(id);
    }

    @Override
    public Collection<Patient> findByWard(Integer ward) {
        return patientRepository.findByWard(ward);
    }

    @Override
    public ResponseEntity<Patient> create(Patient p) {
        if(!getWard(p.getWid()).equals(HttpStatus.OK))
             return new ResponseEntity<Patient>(HttpStatus.BAD_REQUEST);
        if(patientRepository.existsById(p.getId())){
            return new ResponseEntity<Patient>(HttpStatus.BAD_REQUEST);
        }
        patientRepository.save(p);
        return new ResponseEntity<Patient>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Patient> update(Patient p) {
        if(!getWard(p.getWid()).equals(HttpStatus.OK))
            return new ResponseEntity<Patient>(HttpStatus.BAD_REQUEST);
        if(!patientRepository.existsById(p.getId())) {
            return new ResponseEntity<Patient>(HttpStatus.BAD_REQUEST);
        }
        patientRepository.save(p);
        return new ResponseEntity<Patient>(HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Patient> delete(Integer id) {
        if(!patientRepository.existsById(id)) {
            return new ResponseEntity<Patient>(HttpStatus.BAD_REQUEST);
        }
        patientRepository.deleteById(id);
        return new ResponseEntity<Patient>(HttpStatus.OK);
    }
    private HttpStatus getWard(Integer wid) {
        return restTemplate.getForEntity(restURI + "/" + wid, String.class).getStatusCode();
    }


}
