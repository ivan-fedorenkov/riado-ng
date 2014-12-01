package com.mycompany.app.domain.listeners;

import com.mycompany.app.domain.Contacts;
import com.mycompany.app.domain.ContactsEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author ivan
 */
public class ContactsChangeListener {

	@PrePersist
	@PreUpdate
	public void removeBlankContacts(ContactsEntity entity) {
		entity.getContacts().removeIf(Contacts::isBlank);
	}

}
