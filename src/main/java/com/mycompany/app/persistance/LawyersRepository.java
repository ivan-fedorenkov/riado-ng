package com.mycompany.app.persistance;

import com.mycompany.app.domain.Formation;
import com.mycompany.app.domain.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ivan
 */
public interface LawyersRepository extends JpaRepository<Lawyer, Long> {

	List<Lawyer> findLawyersByFormation(Formation formation);

}
