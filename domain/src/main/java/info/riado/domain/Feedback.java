package info.riado.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author ivan
 */
@Entity
public class Feedback extends TextEntity {

	@NotBlank
	@Email
	private String email;

	@NotNull
	private Integer mark;

	private String editorKey;

	@NotNull
	private Boolean approved;

	@NotNull
	private Boolean evidenced;

	@NotNull
	private Boolean hidePersonalInfo;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Lawyer lawyer;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	public String getEditorKey() {
		return editorKey;
	}

	public void setEditorKey(String editorKey) {
		this.editorKey = editorKey;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean getEvidenced() {
		return evidenced;
	}

	public void setEvidenced(Boolean evidenced) {
		this.evidenced = evidenced;
	}

	public Boolean getHidePersonalInfo() {
		return hidePersonalInfo;
	}

	public void setHidePersonalInfo(Boolean hidePersonalInfo) {
		this.hidePersonalInfo = hidePersonalInfo;
	}

	public Lawyer getLawyer() {
		return lawyer;
	}

	public void setLawyer(Lawyer lawyer) {
		this.lawyer = lawyer;
	}
}
