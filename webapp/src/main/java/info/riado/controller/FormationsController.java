package info.riado.controller;

import info.riado.domain.Formation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ivan
 */

@Controller
@RequestMapping("/formations")
public class FormationsController {

	@RequestMapping(value = "/{formation}", method = RequestMethod.GET)
	public String get(Model model, @PathVariable Formation formation) {
		model.addAttribute(formation);
		return "formations/show";
	}

}
