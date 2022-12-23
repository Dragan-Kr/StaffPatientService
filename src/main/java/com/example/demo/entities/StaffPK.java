package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;



public class StaffPK implements Serializable { //AssemblyId
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;


	private Integer id;


	private Integer wardid;

	public StaffPK() {
	}

	public StaffPK(Integer id, Integer wardid) {
		this.id = id;
		this.wardid = wardid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWardid() {
		return wardid;
	}

	public void setWardid(Integer wardid) {
		this.wardid = wardid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StaffPK)) {
			return false;
		}
		StaffPK castOther = (StaffPK)other;
		return
			this.id.equals(castOther.id)
			&& this.wardid.equals(castOther.wardid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.wardid.hashCode();

		return hash;
	}
}
