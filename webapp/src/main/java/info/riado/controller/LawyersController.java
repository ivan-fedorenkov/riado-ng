package info.riado.controller;

import info.riado.domain.EntityFactory;
import info.riado.domain.Lawyer;
import info.riado.persistance.LawyersRepository;
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
