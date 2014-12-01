package com.mycompany.app.domain;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Iterator;
import java.util.List;

/**
 * @author ivan
 */

public interface ContactsEntity {

	List<Contacts> getContacts();

	void setContacts(List<Contacts> contacts);

}
