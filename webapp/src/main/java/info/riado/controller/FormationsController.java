package info.riado.controller;

import info.riado.domain.EntityFactory;
import info.riado.domain.Formation;
import info.riado.persistance.FormationsRepository;
import info.riado.persistance.LawyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ivan
 */

@Controller
@RequestMapping("/formations")
public class FormationsController extends BaseController<Formation> {

	private final LawyersRepository lawyersRepository;

	@Autowired
	public FormationsController(FormationsRepository repository, LawyersRepository lawyersRepository) {
		super(repository, "formation", EntityFactory.FORMATIONS_FACTORY);

		this.lawyersRepository = lawyersRepository;
	}

	@Override
	public String get(Model model) {
		Formation formation = getEntity(model);
		formation.setLawyers(lawyersRepository.findLawyersByFormation(formation));
		return super.get(model);
	}

}
