package info.riado.format;

import info.riado.domain.Feedback;
import info.riado.domain.Formation;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author ivan
 */
public class FeedbackStatusFormatter implements Formatter<Feedback.Status> {

	@Override
	public Feedback.Status parse(String strStatus, Locale locale) throws ParseException {
		try {
			return Feedback.Status.valueOf(strStatus);
		}
		catch(IllegalArgumentException ex) {
			throw new ParseException(strStatus, 0);
		}
	}

	@Override
	public String print(Feedback.Status status, Locale locale) {
		switch (status) {
			case NEW:
				return "Ожидает модерации";
			case APPROVED:
				return "Подтверждён";
			case REJECTED:
				return "Отклонён";
		}
		return "";
	}

}
