package info.riado.beans;

import info.riado.domain.Feedback;
import info.riado.utils.FileResourceExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author ivan
 */
@Component
public class FeedbackTemplate extends Feedback {

	@Autowired
	public FeedbackTemplate(ApplicationContext ctx) throws IOException {
		Resource templateResource = ctx.getResource("classpath:texts/FeedbackTemplate.txt");
		text = FileResourceExtractor.getResourceAsString(templateResource);
	}

}
