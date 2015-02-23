package info.riado.controller;

import info.riado.persistance.FeedbacksRepository;
import info.riado.persistance.NewsRepository;
import info.riado.persistance.PublicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static info.riado.persistance.TextEntityRepository.RECENT_5;

/**
 * @author ivan
 */
@Controller
public class HomeController {

	private final NewsRepository newsRepository;
	private final FeedbacksRepository feedbacksRepository;
	private final PublicationsRepository publicationsRepository;

	@Autowired
	public HomeController(NewsRepository newsRepository, FeedbacksRepository feedbacksRepository,
		PublicationsRepository publicationsRepository)
	{
		this.newsRepository = newsRepository;
		this.feedbacksRepository = feedbacksRepository;
		this.publicationsRepository = publicationsRepository;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String get(Model model) {
		model.addAttribute("newsList", newsRepository.findAll(RECENT_5));
		model.addAttribute("feedbacks", feedbacksRepository.findApprovedFeedbacks(RECENT_5));
		model.addAttribute("publications", publicationsRepository.findAll(RECENT_5));
		return "home/index";
	}

}
