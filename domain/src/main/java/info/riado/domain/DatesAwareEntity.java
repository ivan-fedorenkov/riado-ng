package info.riado.domain;

import java.util.Date;

/**
 * @author ivan
 */
public interface DatesAwareEntity {

	Date getCreatedAt();
	void setCreatedAt(Date date);

	Date getUpdatedAt();
	void setUpdatedAt(Date date);

}
