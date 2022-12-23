package com.example.demo.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@IdClass(DoctorPK.class)
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Id
	private Integer warid;

	private String speciality;

	public Doctor() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWarid() {
		return warid;
	}

	public void setWarid(Integer warid) {
		this.warid = warid;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

}
