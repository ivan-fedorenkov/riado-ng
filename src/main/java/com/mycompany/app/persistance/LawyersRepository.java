package com.mycompany.app.persistance;

import com.mycompany.app.domain.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan
 */
public interface LawyersRepository extends JpaRepository<Lawyer, Long> {
}
