package info.riado.persistance;

import info.riado.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan
 */
public interface FeedbacksRepository extends TextEntityRepository<Feedback>, JpaRepository<Feedback, Long> {
}
