package info.riado.controller;

import info.riado.domain.Lawyer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ivan
 */

@Controller
@RequestMapping("/lawyers")
public class LawyersController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(Model model, @PathVariable("id") Lawyer lawyer) {
		model.addAttribute(lawyer);
		return "lawyers/show";
	}

}
