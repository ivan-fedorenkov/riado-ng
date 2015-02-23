package info.riado.persistance;

import info.riado.domain.Lawyer;
import info.riado.domain.Publication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ivan
 */
public interface PublicationsRepository extends JpaRepository<Publication, Long>, TextEntityRepository<Publication> {

	List<Publication> findPublicationsByLawyer(Lawyer lawyer, Pageable pageable);

}
