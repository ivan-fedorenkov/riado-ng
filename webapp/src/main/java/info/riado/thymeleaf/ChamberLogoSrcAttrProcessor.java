package info.riado.thymeleaf;

import info.riado.domain.Chamber;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.thymeleaf.Arguments;
import org.thymeleaf.Configuration;
import org.thymeleaf.dom.Element;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.processor.attr.AbstractSingleAttributeModifierAttrProcessor;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

/**
 * @author ivan
 */
public class ChamberLogoSrcAttrProcessor extends AbstractSingleAttributeModifierAttrProcessor {

	public static final int ATTR_PRECEDENCE = 12000;
	public static final String ATTR_NAME = "chamber_logo_src";
	public static final String TARGET_ATTR_NAME = "src";

	public ChamberLogoSrcAttrProcessor() {
		super(ATTR_NAME);
	}

	@Override
	protected String getTargetAttributeName(Arguments arguments, Element element, String attributeName) {
		return TARGET_ATTR_NAME;
	}

	@Override
	protected String getTargetAttributeValue(Arguments arguments, Element element, String attributeName) {
		final String attributeValue = element.getAttributeValue(attributeName);

		final Configuration configuration = arguments.getConfiguration();
		final IStandardExpressionParser expressionParser = StandardExpressions.getExpressionParser(configuration);

		final IStandardExpression expression = expressionParser.parseExpression(configuration, arguments, attributeValue);

		final Object object = expression.execute(configuration, arguments);

		if (!(object instanceof Chamber))
			throw new TemplateProcessingException("Object must be of type info.riado.domain.Chamber");

		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
		builder.path("/assets/images/regions/{id}.png");
		return builder.buildAndExpand(((Chamber) object).getId()).toUriString();
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
