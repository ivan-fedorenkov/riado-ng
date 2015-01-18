package info.riado.controller;

import info.riado.domain.Feedback;
import info.riado.persistance.FeedbacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ivan
 */
@Controller
@RequestMapping("/feedbacks")
public class FeedbacksController {

	private final FeedbacksRepository repository;

	@Autowired
	public FeedbacksController(FeedbacksRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model,
        @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 5) Pageable pageable)
	{
		model.addAttribute("feedbacks", repository.findAll(pageable));
		return "feedbacks/index";
	}

	@RequestMapping(value = "/{feedback}", method = RequestMethod.GET)
	public String show(Model model, @PathVariable Feedback feedback) {
		model.addAttribute(feedback);
		return "feedbacks/show";
	}

}
