package com.mycompany.app.controller;

import com.mycompany.app.domain.EntityFactory;
import com.mycompany.app.domain.Formation;
import com.mycompany.app.persistance.FormationsRepository;
import com.mycompany.app.persistance.LawyersRepository;
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
