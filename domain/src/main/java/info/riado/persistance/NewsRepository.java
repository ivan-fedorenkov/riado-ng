package info.riado.persistance;

import info.riado.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan
 */
public interface NewsRepository extends JpaRepository<News, Long>, TextEntityRepository<News> {
}
