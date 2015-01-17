package info.riado.persistance;

import info.riado.domain.TextEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author ivan
 */
public interface TextEntityRepository<T extends TextEntity>  {

	Optional<T> findFirstByIdAfterOrderByIdAsc(Long id);
	Optional<T> findFirstByIdBeforeOrderByIdDesc(Long id);

}
