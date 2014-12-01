package com.mycompany.app.controller;

import com.mycompany.app.domain.BaseEntity;
import com.mycompany.app.domain.EntityFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ivan
 */

@Controller
public abstract class BaseController<T extends BaseEntity> {

	protected final JpaRepository<T, Long> repository;
	protected final String entityName;
	protected final EntityFactory<T> factory;

	protected final String indexView;
	protected final String showView;
	protected final String newView;
	protected final String createView;

	private final Pattern entityRequestPattern;

	public BaseController(JpaRepository<T, Long> repository, String entityName, EntityFactory<T> factory) {
		this.repository = repository;
		this.entityName = entityName;
		this.factory = factory;

		indexView = entityName + "/index";
		showView = entityName + "/show";
		newView = entityName + "/new";
		createView = "redirect:/" + entityName;

		entityRequestPattern = Pattern.compile("/" + entityName + "/(\\d+)[^\\d]*");
	}

	@ModelAttribute
	public T setEntity(HttpServletRequest request) {
		Matcher m = entityRequestPattern.matcher(request.getRequestURI());
		if (m.matches())
			return repository.getOne(Long.valueOf(m.group(1)));
		return factory.create();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, Pageable pageable) {
		model.addAttribute(entityName, repository.findAll(pageable));
		return indexView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get() {
		return showView;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String _new() {
		return newView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@ModelAttribute T entity) {
		repository.save(entity);
		return createView;
	}

}
