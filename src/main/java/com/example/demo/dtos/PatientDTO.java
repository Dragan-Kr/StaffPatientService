package com.example.demo.dtos;

import com.example.demo.entities.Patient;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class PatientDTO {
    private Integer id;


    private Date accepted;

    private String allergies;

    private String insurance;

    private String prescriptions;

    private String sickeness;

    private String spec_reqs;

    private Integer wid;

    public  PatientDTO(Patient patient){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAccepted() {
        return accepted;
    }

    public void setAccepted(Date accepted) {
        this.accepted = accepted;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getSickeness() {
        return sickeness;
    }

    public void setSickeness(String sickeness) {
        this.sickeness = sickeness;
    }

    public String getSpec_reqs() {
        return spec_reqs;
    }

    public void setSpec_reqs(String spec_reqs) {
        this.spec_reqs = spec_reqs;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }
}
