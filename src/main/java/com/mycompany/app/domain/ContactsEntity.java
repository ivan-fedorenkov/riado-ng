package com.mycompany.app.domain;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.*;

/**
 * @author ivan
 */

public interface ContactsEntity {

	List<Contacts> getContacts();

	void setContacts(List<Contacts> contacts);

	default List<Contacts> getComplementedContacts() {
		List<Contacts> contacts = getContacts();

		EnumSet<Contacts.Type> existingTypes = EnumSet.noneOf(Contacts.Type.class);
		contacts.forEach(c -> {
			existingTypes.add(c.getType());
		});
		EnumSet<Contacts.Type> nonExistingTypes = EnumSet.complementOf(existingTypes);

		nonExistingTypes.forEach(t -> {
			Contacts c = new Contacts();
			c.setType(t);
			c.setValue("");
			contacts.add(c);
		});

		Collections.sort(contacts, TYPE_COMPARATOR);

		return contacts;
	}

	Comparator<Contacts> TYPE_COMPARATOR = (c1, c2) -> {
		return Integer.compare(c1.getType().ordinal(), c2.getType().ordinal());
	};

}
