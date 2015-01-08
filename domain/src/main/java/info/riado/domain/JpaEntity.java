package info.riado.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ivan
 */

@MappedSuperclass
public abstract class JpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Version
	protected Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
