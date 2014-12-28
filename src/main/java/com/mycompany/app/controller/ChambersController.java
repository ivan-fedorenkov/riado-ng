package com.mycompany.app.controller;

import com.mycompany.app.domain.Chamber;
import com.mycompany.app.domain.EntityFactory;
import com.mycompany.app.domain.Formation;
import com.mycompany.app.domain.Lawyer;
import com.mycompany.app.persistance.ChambersRepository;
import com.mycompany.app.persistance.FormationsRepository;
import com.mycompany.app.persistance.LawyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

/**
 * @author ivan
 */

@Controller
@RequestMapping("/chambers")
public class ChambersController extends BaseController<Chamber> {

	private final LawyersRepository lawyersRepository;
	private final FormationsRepository formationsRepository;

	@Autowired
	public ChambersController(ChambersRepository repository, LawyersRepository lawyersRepository,
		FormationsRepository formationsRepository)
	{
		super(repository, "chamber", EntityFactory.CHAMBERS_FACTORY);

		this.lawyersRepository = lawyersRepository;
		this.formationsRepository = formationsRepository;
	}

	@RequestMapping(value = "/{chamberId}/lawyers/new", method = RequestMethod.GET)
	public String newAdvocate(Model model) {
		Lawyer lawyer = EntityFactory.LAWYERS_FACTORY.create();
		lawyer.setChamber(getEntity(model));
		model.addAttribute(lawyer);
		return "lawyers/new";
	}

	@RequestMapping(value = "/{chamberId}/lawyers", method = RequestMethod.POST)
	public String createAdvocate(Model model, @ModelAttribute Lawyer lawyer) {
		Chamber chamber = getEntity(model);
		lawyer.setChamber(chamber);
		lawyersRepository.save(lawyer);
		return "redirect:/chambers/" + chamber.getId();
	}

	@RequestMapping(value = "/{chamberId}/formations/new", method = RequestMethod.GET)
	public String newFormations(Model model) {
		Formation formation = EntityFactory.FORMATIONS_FACTORY.create();
		formation.setChamber(getEntity(model));
		model.addAttribute(formation);
		model.addAttribute("formationForms", Arrays.asList(Formation.Form.values()));
		return "formations/new";
	}

	@RequestMapping(value = "/{chamberId}/formations", method = RequestMethod.POST)
	public String createFormation(Model model, @ModelAttribute Formation formation) {
		Chamber chamber = getEntity(model);
		formation.setChamber(chamber);
		formationsRepository.save(formation);
		return "redirect:/formations/" + formation.getId();
	}

}
