package info.riado.persistance;

import info.riado.domain.TextEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

/**
 * @author ivan
 */
public interface TextEntityRepository<T extends TextEntity>  {

	Optional<T> findFirstByIdAfterOrderByIdAsc(Long id);
	Optional<T> findFirstByIdBeforeOrderByIdDesc(Long id);

	Pageable RECENT_5 = new PageRequest(0, 5, Sort.Direction.DESC, "id");
	Pageable RECENT_10 = new PageRequest(0, 10, Sort.Direction.DESC, "id");

}
