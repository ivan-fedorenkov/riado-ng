package info.riado.lifecycle;

import info.riado.domain.DatesAwareEntity;

import javax.persistence.PreUpdate;

/**
 * @author ivan
 */

public class ModificationDateListener {

	@PreUpdate
	public void setModificationDate(DatesAwareEntity entity) {
		entity.getUpdatedAt().setTime(System.currentTimeMillis());
	}

}
