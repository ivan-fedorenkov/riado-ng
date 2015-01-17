package info.riado.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author ivan
 */
@Entity
public class Publication extends TextEntity {

	@NotBlank
	private String title;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Lawyer lawyer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Lawyer getLawyer() {
		return lawyer;
	}

	public void setLawyer(Lawyer lawyer) {
		this.lawyer = lawyer;
	}

}
