package info.riado.persistance;

import info.riado.domain.Chamber;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan
 */
public interface ChambersRepository extends JpaRepository<Chamber, Long> {
}
