package info.riado.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan
 */

@Entity
public class Chamber extends BaseEntity implements ContactsEntity {

	@NotBlank
	@Column(unique = true)
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Contacts> contacts = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Contacts> getContacts() {
		return contacts;
	}

	@Override
	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}

}
