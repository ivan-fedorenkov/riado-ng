package info.riado.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ivan
 */
public class TextHelper {

	private static final int DEFAULT_PREVIEW_TRIM_LENGTH = 1000;
	private static final Pattern HTML_PATTERN = Pattern.compile("<.*?>", Pattern.MULTILINE | Pattern.DOTALL);

	public String trim(String text, int trimLength) {
		if(text.length() > trimLength) {
			text = text.substring(0, trimLength);
			text = text.concat("..");
		}
		return text;
	}

	public String removeHtml(String text) {
		Matcher m = HTML_PATTERN.matcher(text);
		StringBuffer textBuffer = new StringBuffer();
		while (m.find())
			m.appendReplacement(textBuffer, "");
		m.appendTail(textBuffer);
		return textBuffer.toString();
	}

	public String preview(String text) {
		return trim(removeHtml(text), DEFAULT_PREVIEW_TRIM_LENGTH);
	}

}
