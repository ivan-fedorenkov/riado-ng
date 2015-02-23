package info.riado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ivan
 */
@Controller
public class SessionsController {

	@RequestMapping(value = "/sessions/new", method = RequestMethod.GET)
	public String _new() {
		return "sessions/new";
	}

}
