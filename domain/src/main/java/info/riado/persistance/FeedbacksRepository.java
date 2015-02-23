package info.riado.persistance;

import info.riado.domain.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan
 */
public interface FeedbacksRepository extends TextEntityRepository<Feedback>, JpaRepository<Feedback, Long> {

	Page<Feedback> findFeedbacksByStatus(Feedback.Status status, Pageable pageable);

	default Page<Feedback> findApprovedFeedbacks(Pageable pageable) {
		return findFeedbacksByStatus(Feedback.Status.APPROVED, pageable);
	}

}
