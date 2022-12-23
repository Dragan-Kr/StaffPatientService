package com.example.demo.ctrls;

import com.example.demo.dtos.PatientDTO;
import com.example.demo.entities.Patient;
import com.example.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8083")
@RestController
public class PatientRestController {

    @Autowired
    private PatientService patientService;


    @GetMapping("patient")
    public Collection<Patient> getPatients(@RequestParam(value="ward",required = false) Integer ward){

        if(ward != null)
            return patientService.findByWard(ward);

        return patientService.findAllObjects();
    }

//    @GetMapping("patient/{id}")
//    public Patient getPatient(@PathVariable("id") Integer id)
//    {
//          Patient patient = patientService.getOneObject(id);
//          PatientDTO patientDTO = new PatientDTO(patient);
//          return patient;
//    }

    @GetMapping("patient/{id}")
    public Patient getByID(@PathVariable ("id") Integer id) {
        return patientService.getOneObject(id);
    }




    @PostMapping("patient")
    public ResponseEntity<Patient> add(@RequestBody Patient patient) {
        return patientService.create(patient);
    }


    @PutMapping("patient")
    public ResponseEntity<Patient> update(@RequestBody Patient patient) {
        return patientService.update(patient);
    }

    @DeleteMapping("menu/{id}")
    public ResponseEntity<Patient> delete(@PathVariable ("id") Integer id) {
        return patientService.delete(id);
    }

}
