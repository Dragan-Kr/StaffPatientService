package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the room database table.
 * 
 */
public class RoomPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer id;

	@Column(insertable=false, updatable=false)
	private Integer wid;

	public RoomPK() {
	}

	public RoomPK(Integer id,Integer wid){
		this.id=id;
		this.wid=wid;

	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWid() {
		return this.wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RoomPK)) {
			return false;
		}
		RoomPK castOther = (RoomPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.wid.equals(castOther.wid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.wid.hashCode();
		
		return hash;
	}
}
