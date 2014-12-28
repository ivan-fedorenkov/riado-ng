package com.mycompany.app.persistance;

import com.mycompany.app.domain.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan
 */
public interface FormationsRepository extends JpaRepository<Formation, Long> {
}
