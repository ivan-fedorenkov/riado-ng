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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("feedbacks", repository.findApprovedFeedbacks(pageable));
		return "feedbacks/index";
	}

	@RequestMapping(value = "/{feedback}", method = RequestMethod.GET)
	public String show(Model model, @PathVariable Feedback feedback) {
		model.addAttribute(feedback);
		return "feedbacks/show";
	}

	@RequestMapping(value = "/{feedback}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable Feedback feedback, @RequestParam String editorKey,
       RedirectAttributes redirectAttributes)
	{
		if (feedback.canBeEdited(editorKey)) {
			return "feedbacks/edit";
		} else {
			redirectAttributes.addFlashAttribute("error", "Доступ к редактированию отзыва запрещён.");
			return "redirect:/lawyers/" + feedback.getLawyer().getId();
		}
	}

	@RequestMapping(value = "/{feedback}", method = RequestMethod.PATCH)
	public String patch(Model model, @PathVariable Feedback feedback, WebRequest request,
        @RequestParam String editorKey, RedirectAttributes redirectAttributes)
	{
		if (feedback.canBeEdited(editorKey)) {
			WebRequestDataBinder binder = new WebRequestDataBinder(feedback);
			binder.setAllowedFields("email", "mark", "text");
			binder.bind(request);
			feedback = repository.saveAndFlush(feedback);
			model.addAttribute(feedback);
			redirectAttributes.addFlashAttribute("success", "Отзыв успешно отредактирован.");
			return "redirect:/feedbacks/" + feedback.getId() + "/edit?editorKey=" + editorKey;
		} else {
			redirectAttributes.addFlashAttribute("error", "Доступ к редактированию отзыва запрещён.");
			return "redirect:/lawyers/" + feedback.getLawyer().getId();
		}
	}

}
