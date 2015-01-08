package info.riado.domain;

import info.riado.lifecycle.ModificationDateListener;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ivan
 */

@Entity
@EntityListeners({ModificationDateListener.class})
public class Chamber extends JpaEntity implements DatesAwareEntity,	ContactsEntity {

	@NotBlank
	@Column(unique = true)
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Contact> contacts = new ArrayList<>();

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date createdAt = new Date();

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date updatedAt = new Date();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Contact> getContacts() {
		return contacts;
	}

	@Override
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
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
}
