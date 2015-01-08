package info.riado.thymeleaf;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ivan
 */
public class RiadoDialect extends AbstractDialect {
	@Override
	public String getPrefix() {
		return "r";
	}

	@Override
	public Set<IProcessor> getProcessors() {
		Set<IProcessor> processors = new HashSet<>();
		processors.add(new ClassForTopContactsIconAttrProcessor());
		processors.add(new HrefAttrProcessor());
		processors.add(new ChamberLogoSrcAttrProcessor());
		return processors;
	}
}
