package info.riado.thymeleaf;

import info.riado.domain.Chamber;
import info.riado.domain.Formation;
import info.riado.domain.News;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.thymeleaf.Arguments;
import org.thymeleaf.Configuration;
import org.thymeleaf.dom.Element;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.processor.attr.AbstractSingleAttributeModifierAttrProcessor;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

import java.util.Optional;

/**
 * @author ivan
 */
public class HrefAttrProcessor extends AbstractSingleAttributeModifierAttrProcessor {

	public static final int ATTR_PRECEDENCE = 12000;
	public static final String ATTR_NAME = "href";

	public HrefAttrProcessor() {
		super(ATTR_NAME);
	}

	@Override
	protected String getTargetAttributeName(Arguments arguments, Element element, String attributeName) {
		return ATTR_NAME;
	}

	@Override
	protected String getTargetAttributeValue(Arguments arguments, Element element, String attributeName) {
		final String attributeValue = element.getAttributeValue(attributeName);

		final Configuration configuration = arguments.getConfiguration();
		final IStandardExpressionParser expressionParser = StandardExpressions.getExpressionParser(configuration);

		final IStandardExpression expression = expressionParser.parseExpression(configuration, arguments, attributeValue);

		Object object = expression.execute(configuration, arguments);

		if (object instanceof Optional)
			object = ((Optional) object).get();

		if (object instanceof Chamber) {
			ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
			builder.path("/chambers/{id}");
			return builder.buildAndExpand(((Chamber) object).getId()).toUriString();
		} else if (object instanceof Formation) {
			ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
			builder.path("/formations/{id}");
			return builder.buildAndExpand(((Formation) object).getId()).toUriString();
		} else if (object instanceof News) {
			ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
			builder.path("/news/{id}");
			return builder.buildAndExpand(((News) object).getId()).toUriString();
		} else {
			throw new TemplateProcessingException("Can't create href for object of type: " + object.getClass());
		}
	}

	@Override
	protected ModificationType getModificationType(Arguments arguments, Element element, String attributeName, String newAttributeName) {
		return ModificationType.SUBSTITUTION;
	}

	@Override
	protected boolean removeAttributeIfEmpty(Arguments arguments, Element element, String attributeName, String newAttributeName) {
		return false;
	}

	@Override
	protected boolean recomputeProcessorsAfterExecution(Arguments arguments, Element element, String attributeName) {
		return false;
	}

	@Override
	public int getPrecedence() {
		return ATTR_PRECEDENCE;
	}
}
