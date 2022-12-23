package com.example.demo.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nurse database table.
 * 
 */
@Entity
@NamedQuery(name="Nurse.findAll", query="SELECT n FROM Nurse n")
public class Nurse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NursePK id;

	private Boolean ishead;

	public Nurse() {
	}

	public NursePK getId() {
		return this.id;
	}

	public void setId(NursePK id) {
		this.id = id;
	}

	public Boolean getIshead() {
		return this.ishead;
	}

	public void setIshead(Boolean ishead) {
		this.ishead = ishead;
	}

}
