package info.riado.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * @author ivan
 */

@Entity
public class Contact extends JpaEntity {

	@NotNull
	@Enumerated(EnumType.STRING)
	private Type type;

	@NotBlank
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isBlank() {
		return value == null || value.isEmpty();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Contact contact = (Contact) o;

		if (type != contact.type)
			return false;
		if (!value.equals(contact.value))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = type.hashCode();
		result = 31 * result + value.hashCode();
		return result;
	}

	public enum Type { PHONE, WEBSITE, ADDRESS, EMAIL }

}
