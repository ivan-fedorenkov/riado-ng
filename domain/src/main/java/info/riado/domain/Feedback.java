package info.riado.domain;

import info.riado.utils.RandomKeyGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author ivan
 */
@Entity
public class Feedback extends TextEntity {

	private static final int EDITOR_KEY_LENGTH = 10;

	@NotBlank
	@Email
	private String email;

	@NotNull
	private Integer mark;

	private String editorKey;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status = Status.NEW;

	private boolean evidenced;

	private boolean hidePersonalInfo = true;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Lawyer lawyer;

	public boolean canBeEdited(String editorKey) {
		return Objects.equals(this.editorKey, editorKey);
	}

	@PrePersist
	private void prePersist() {
		editorKey = RandomKeyGenerator.generateKey(RandomKeyGenerator.VALID_URL_SYMBOLS, EDITOR_KEY_LENGTH);
	}

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isEvidenced() {
		return evidenced;
	}

	public void setEvidenced(boolean evidenced) {
		this.evidenced = evidenced;
	}

	public boolean isHidePersonalInfo() {
		return hidePersonalInfo;
	}

	public void setHidePersonalInfo(boolean hidePersonalInfo) {
		this.hidePersonalInfo = hidePersonalInfo;
	}

	public Lawyer getLawyer() {
		return lawyer;
	}

	public void setLawyer(Lawyer lawyer) {
		this.lawyer = lawyer;
	}

	public enum Status {
		NEW, APPROVED, REJECTED
	}

}
