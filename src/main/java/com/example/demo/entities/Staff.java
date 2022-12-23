package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the staff database table.
 * 
 */
@Entity
@IdClass(StaffPK.class)
public class Staff implements Serializable { //Assembly
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Id
	private Integer wardid;

	private String education;

	@Transient
	private Ward ward;

	@Transient
	private Person person;

	@Column(name="foren_languages")
	private String foren_languages;

	@Temporal(TemporalType.DATE)
	private Date joined;

	public Staff() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	public void setWardid(Integer wardid) {
		this.wardid = wardid;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getForen_languages() {
		return foren_languages;
	}

	public void setForen_languages(String foren_languages) {
		this.foren_languages = foren_languages;
	}

	public Date getJoined() {
		return this.joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}

	public Integer getWardid() {
		return wardid;
	}

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
