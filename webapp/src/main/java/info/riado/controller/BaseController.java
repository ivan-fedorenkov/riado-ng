package info.riado.controller;

import info.riado.domain.BaseEntity;
import info.riado.domain.ContactsEntity;
import info.riado.domain.EntityFactory;
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
	protected final String entityNamePlural;
	protected final EntityFactory<T> factory;

	protected final String indexView;
	protected final String showView;
	protected final String newView;
	protected final String editView;
	protected final String redirectView;

	private final boolean isContactsEntity;
	private final Pattern entityRequestPattern;

	public BaseController(JpaRepository<T, Long> repository, String entityName, EntityFactory<T> factory) {
		this.repository = repository;
		this.entityName = entityName;
		entityNamePlural = entityName.endsWith("s") ? entityName : entityName + "s";
		this.factory = factory;

		indexView = entityNamePlural + "/index";
		showView = entityNamePlural + "/show";
		newView = entityNamePlural + "/new";
		editView = entityNamePlural + "/edit";
		redirectView = "redirect:/" + entityNamePlural;

		isContactsEntity = factory.create() instanceof ContactsEntity;
		entityRequestPattern = Pattern.compile("/" + entityNamePlural + "/(\\d+)[^\\d]*");
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
		model.addAttribute(entityNamePlural, repository.findAll(pageable));
		return indexView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(Model model) {
		return showView;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String _new(@ModelAttribute T entity) {
		if (isContactsEntity) {
			ContactsEntity contactsEntity = (ContactsEntity) entity;
			contactsEntity.setContacts(contactsEntity.getComplementedContacts());
		}
		return newView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@ModelAttribute T entity) {
		repository.save(entity);
		return redirectView;
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@ModelAttribute T entity) {
		if (isContactsEntity) {
			ContactsEntity contactsEntity = (ContactsEntity) entity;
			contactsEntity.setContacts(contactsEntity.getComplementedContacts());
		}
		return editView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public String patch(@ModelAttribute T entity) {
		repository.save(entity);
		return redirectView + "/" + entity.getId();
	}

	@SuppressWarnings("unchecked")
	protected T getEntity(Model model) {
		return (T) model.asMap().get(entityName);
	}

}
