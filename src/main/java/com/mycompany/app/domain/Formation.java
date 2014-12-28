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
public class Formation extends BaseEntity implements ContactsEntity {

	@NotBlank
	private String name;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private Form form;

	@NotNull
	@ManyToOne
	private Chamber chamber;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Contacts> contacts = new ArrayList<>();

	private transient List<Lawyer> lawyers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public Chamber getChamber() {
		return chamber;
	}

	public void setChamber(Chamber chamber) {
		this.chamber = chamber;
	}

	@Override
	public List<Contacts> getContacts() {
		return contacts;
	}

	@Override
	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}

	public List<Lawyer> getLawyers() {
		return lawyers;
	}

	public void setLawyers(List<Lawyer> lawyers) {
		this.lawyers = lawyers;
	}

	public enum Form { CABINET, COLLEGE, BUREAU, CONSULTATION }

}
