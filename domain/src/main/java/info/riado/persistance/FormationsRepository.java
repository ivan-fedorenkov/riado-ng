package info.riado.persistance;

import info.riado.domain.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan
 */
public interface FormationsRepository extends JpaRepository<Formation, Long> {
}
