package com.mycompany.app.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan
 */

@Entity
public class Lawyer extends BaseEntity implements ContactsEntity {

	@NotBlank
	private String name;

	@NotBlank
	@Column(unique = true)
	private String regNum;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Contacts> contacts = new ArrayList<>();

	@NotNull
	@ManyToOne
	private Chamber chamber;

	@ManyToOne
	private Formation formation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public List<Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}

	public Chamber getChamber() {
		return chamber;
	}

	public void setChamber(Chamber chamber) {
		this.chamber = chamber;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
}
