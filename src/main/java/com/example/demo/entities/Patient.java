package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PATIENT_ID_GENERATOR", sequenceName="PATIENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date accepted;

	private String allergies;

	private String insurance;

	private String prescriptions;

	private String sickeness;

	@Column(name="spec_reqs")
	private String spec_reqs;

	private Integer wid;

	public Patient() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAccepted() {
		return this.accepted;
	}

	public void setAccepted(Date accepted) {
		this.accepted = accepted;
	}

	public String getAllergies() {
		return this.allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getInsurance() {
		return this.insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}

	public String getSickeness() {
		return this.sickeness;
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
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

}
