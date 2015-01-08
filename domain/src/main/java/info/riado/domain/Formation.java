package info.riado.domain;

import info.riado.lifecycle.ModificationDateListener;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ivan
 */

@Entity
@EntityListeners({ModificationDateListener.class})
public class Formation extends JpaEntity implements DatesAwareEntity, ContactsEntity {

	@NotBlank
	private String name;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private Form form;

	@NotNull
	@ManyToOne
	private Chamber chamber;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Contact> contacts = new ArrayList<>();

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date createdAt = new Date();

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date updatedAt = new Date();

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
	public List<Contact> getContacts() {
		return contacts;
	}

	@Override
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Lawyer> getLawyers() {
		return lawyers;
	}

	public void setLawyers(List<Lawyer> lawyers) {
		this.lawyers = lawyers;
	}

	@Override
	public Date getCreatedAt() {
		return createdAt;
	}

	@Override
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public Date getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public enum Form { CABINET, COLLEGE, BUREAU, CONSULTATION }

}
