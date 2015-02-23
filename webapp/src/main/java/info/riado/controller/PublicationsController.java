package info.riado.controller;

import info.riado.domain.Publication;
import info.riado.persistance.PublicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static info.riado.persistance.TextEntityRepository.*;

/**
 * @author ivan
 */
@Controller
@RequestMapping("/publications")
public class PublicationsController {

	private final PublicationsRepository repository;

	@Autowired
	public PublicationsController(PublicationsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model,
        @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 5) Pageable pageable)
	{
		model.addAttribute("publications", repository.findAll(pageable));
		return "publications/index";
	}

	@RequestMapping(value = "/{publication}", method = RequestMethod.GET)
	public String get(Model model, @PathVariable Publication publication) {
		model.addAttribute(publication);
		List<Publication> last10 = repository.findPublicationsByLawyer(publication.getLawyer(), RECENT_10);
		if (!last10.isEmpty())
			last10.remove(publication);
		model.addAttribute("last10publications", last10);
		return "publications/show";
	}

}
