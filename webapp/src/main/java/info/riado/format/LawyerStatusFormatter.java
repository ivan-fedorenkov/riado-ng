package info.riado.format;

import info.riado.domain.Lawyer;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author ivan
 */
public class LawyerStatusFormatter implements Formatter<Lawyer.Status> {

	@Override
	public Lawyer.Status parse(String strStatus, Locale locale) throws ParseException {
		try {
			return Lawyer.Status.valueOf(strStatus);
		} catch (IllegalArgumentException iae) {
			throw new ParseException(strStatus, 0);
		}
	}

	@Override
	public String print(Lawyer.Status status, Locale locale) {
		switch (status) {
			case ACTIVE:
				return "Статус активен";
			case SUSPENDED:
				return "Статус приостановлен";
			case STOPPED:
				return "Статус прекращён";
			case REMOVED:
				return "Удалён из реестра";
		}
		return "";
	}
}
