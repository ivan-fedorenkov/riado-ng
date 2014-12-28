package com.mycompany.app.controller;

import com.mycompany.app.domain.EntityFactory;
import com.mycompany.app.domain.Lawyer;
import com.mycompany.app.persistance.LawyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ivan
 */

@Controller
@RequestMapping("/lawyers")
public class LawyersController extends BaseController<Lawyer> {

	@Autowired
	public LawyersController(LawyersRepository repository) {
		super(repository, "lawyer", EntityFactory.LAWYERS_FACTORY);
	}

}
