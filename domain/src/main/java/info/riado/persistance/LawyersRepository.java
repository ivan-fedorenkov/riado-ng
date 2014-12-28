package info.riado.persistance;

import info.riado.domain.Formation;
import info.riado.domain.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ivan
 */
public interface LawyersRepository extends JpaRepository<Lawyer, Long> {

	List<Lawyer> findLawyersByFormation(Formation formation);

}
