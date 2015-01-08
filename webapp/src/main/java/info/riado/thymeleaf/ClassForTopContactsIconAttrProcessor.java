package info.riado.thymeleaf;

import info.riado.domain.Contact;
import org.thymeleaf.Arguments;
import org.thymeleaf.Configuration;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractAttributeModifierAttrProcessor;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

import java.util.Collections;
import java.util.Map;

/**
 * @author ivan
 */
public class ClassForTopContactsIconAttrProcessor extends AbstractAttributeModifierAttrProcessor {

	public static final int ATTR_PRECEDENCE = 12000;
	public static final String ATTR_NAME = "contacts_icon_class";

	public ClassForTopContactsIconAttrProcessor() {
		super(ATTR_NAME);
	}

	@Override
	protected Map<String, String> getModifiedAttributeValues(Arguments arguments, Element element, String attributeName) {
		Configuration configuration = arguments.getConfiguration();
		String attributeValue = element.getAttributeValue(attributeName);
		IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
		IStandardExpression expression = parser.parseExpression(configuration, arguments, attributeValue);

		Contact.Type contactType = (Contact.Type) expression.execute(configuration, arguments);

		String className = "";
        switch (contactType) {
	        case ADDRESS:
		        className = "icon-home";
		        break;
	        case PHONE:
		        className = "icon-user";
		        break;
	        case WEBSITE:
		        className = "icon-globe";
		        break;
	        case EMAIL:
		        className = "icon-envelope";

        }
		return Collections.singletonMap("class", className);
	}

	@Override
	protected ModificationType getModificationType(Arguments arguments, Element element, String attributeName, String newAttributeName) {
		return ModificationType.SUBSTITUTION;
	}

	@Override
	protected boolean removeAttributeIfEmpty(Arguments arguments, Element element, String attributeName, String newAttributeName) {
		return true;
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
