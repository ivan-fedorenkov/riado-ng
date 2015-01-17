package info.riado.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * @author ivan
 */
@Entity
public class News extends TextEntity {

	@NotBlank
	private String title;

	@Lob
	private String preview;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}
}
