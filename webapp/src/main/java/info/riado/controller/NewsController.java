package info.riado.controller;

import info.riado.domain.News;
import info.riado.persistance.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ivan
 */
@Controller
@RequestMapping("/news")
public class NewsController {

	private final NewsRepository newsRepository;

	@Autowired
	public NewsController(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model,
        @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size=5) Pageable pageable)
	{
		model.addAttribute("newsList", newsRepository.findAll(pageable));
		return "news/index";
	}

	@RequestMapping(value = "/{news}", method = RequestMethod.GET)
	public String get(Model model, @PathVariable News news) {
		model.addAttribute(news);
		model.addAttribute("next", newsRepository.findFirstByIdAfterOrderByIdAsc(news.getId()));
		model.addAttribute("prev", newsRepository.findFirstByIdBeforeOrderByIdDesc(news.getId()));
		return "news/show";
	}

}
