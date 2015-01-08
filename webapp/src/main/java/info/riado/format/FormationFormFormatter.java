package info.riado.format;

import info.riado.domain.Formation;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author ivan
 */
public class FormationFormFormatter implements Formatter<Formation.Form> {

	@Override
	public Formation.Form parse(String strForm, Locale locale) throws ParseException {
		try {
			return Formation.Form.valueOf(strForm);
		}
		catch(IllegalArgumentException ex) {
			throw new ParseException(strForm, 0);
		}
	}

	@Override
	public String print(Formation.Form form, Locale locale) {
		switch (form) {
			case CABINET:
				return "Адвокатский кабинет";
			case BUREAU:
				return "Адвокатское бюро";
			case COLLEGE:
				return "Коллегия адвокатов";
			case CONSULTATION:
				return "Юридическая консультация";
		}
		return "";
	}

}
