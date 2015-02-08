package info.riado.controller;

import info.riado.beans.FeedbackTemplate;
import info.riado.domain.Feedback;
import info.riado.domain.Lawyer;
import info.riado.persistance.FeedbacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ivan
 */

@Controller
@RequestMapping("/lawyers")
public class LawyersController {

	private final FeedbacksRepository feedbacksRepository;
	private final FeedbackTemplate feedbackTemplate;

	@Autowired
	public LawyersController(FeedbacksRepository feedbacksRepository, FeedbackTemplate feedbackTemplate) {
		this.feedbacksRepository = feedbacksRepository;
		this.feedbackTemplate = feedbackTemplate;
	}

	@RequestMapping(value = "/{lawyer}", method = RequestMethod.GET)
	public String get(Model model, @PathVariable Lawyer lawyer) {
		model.addAttribute(lawyer);
		model.addAttribute(feedbackTemplate);
		return "lawyers/show";
	}

	@RequestMapping(value = "/{lawyer}/feedbacks", method = RequestMethod.POST)
	public String createFeedback(Model model, @PathVariable Lawyer lawyer, @ModelAttribute Feedback feedback) {
		feedback.setLawyer(lawyer);
		feedback = feedbacksRepository.saveAndFlush(feedback);
		model.addAttribute(feedback);
		return "feedbacks/success";
	}

}
