package com.mycompany.app.controller;

import com.mycompany.app.domain.Chamber;
import com.mycompany.app.domain.EntityFactory;
import com.mycompany.app.domain.Lawyer;
import com.mycompany.app.persistance.ChambersRepository;
import com.mycompany.app.persistance.LawyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author ivan
 */

@Controller
@RequestMapping("/chambers")
public class ChambersController extends BaseController<Chamber> {

	private final LawyersRepository lawyersRepository;

	@Autowired
	public ChambersController(ChambersRepository repository, LawyersRepository lawyersRepository) {
		super(repository, "chambers", EntityFactory.CHAMBERS_FACTORY);

		this.lawyersRepository = lawyersRepository;
	}

	@RequestMapping(value = "/{chamberId}/lawyers/new", method = RequestMethod.GET)
	public String newAdvocate(Model model) {
		Lawyer lawyer = EntityFactory.LAWYERS_FACTORY.create();
		lawyer.setChamber(getChamber(model));
		model.addAttribute(lawyer);
		return "lawyers/new";
	}

	@RequestMapping(value = "/{chamberId}/lawyers", method = RequestMethod.POST)
	public String createAdvocate(Model model, @ModelAttribute Lawyer lawyer) {
		Chamber chamber = getChamber(model);
		lawyer.setChamber(chamber);
		lawyersRepository.save(lawyer);
		return "redirect:/chambers/" + chamber.getId();
	}



	private static Chamber getChamber(Model model) {
		return (Chamber) model.asMap().get("chamber");
	}

}
