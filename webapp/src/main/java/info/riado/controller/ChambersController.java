package info.riado.controller;

import info.riado.domain.Chamber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ivan
 */

@Controller
@RequestMapping("/chambers")
public class ChambersController {

	@RequestMapping(value = "/{chamber}", method = RequestMethod.GET)
	public String get(Model model, @PathVariable Chamber chamber) {
		model.addAttribute(chamber);
		return "chambers/show";
	}

}
