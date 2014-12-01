package com.mycompany.app.domain;

import com.mycompany.app.domain.listeners.ContactsChangeListener;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan
 */

@Entity
@EntityListeners(ContactsChangeListener.class)
public class Lawyer extends BaseEntity implements ContactsEntity {

	@NotBlank
	private String name;

	@NotBlank
	@Column(unique = true)
	private String regNum;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Contacts> contacts = new ArrayList<>();

	@ManyToOne
	private Chamber chamber;

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

}
