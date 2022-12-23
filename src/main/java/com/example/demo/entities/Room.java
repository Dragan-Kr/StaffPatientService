package com.example.demo.entities;

import com.example.demo.entities.RoomPK;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the room database table.
 * 
 */
@Entity
@IdClass(RoomPK.class)
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	private Integer id;

	@Id
	private Integer wid;

	@Column(name="bed_number")
	private Integer bedNumber;

	@Column(name="r_gender")
	private String rGender;



	@Transient
	private Ward ward;


	public Room() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Integer getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(Integer bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getrGender() {
		return rGender;
	}

	public void setrGender(String rGender) {
		this.rGender = rGender;
	}

	public com.example.demo.entities.Ward getWard() {
		return ward;
	}

	public void setWard(com.example.demo.entities.Ward ward) {
		this.ward = ward;
	}
}
