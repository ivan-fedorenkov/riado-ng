package com.mycompany.app.persistance;

import com.mycompany.app.domain.Chamber;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan
 */

public interface ChambersRepository extends JpaRepository<Chamber, Long> {
}
