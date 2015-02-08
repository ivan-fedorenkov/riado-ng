package info.riado.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ivan
 */
public class TextHelper {

	private static final int DEFAULT_PREVIEW_TRIM_LENGTH = 1000;
	private static final Pattern HTML_PATTERN = Pattern.compile("<.*?>", Pattern.MULTILINE | Pattern.DOTALL);
	private static final Pattern LINK_PATTERN = Pattern.compile("<a(.*?)href\\s*=\\s*['\"](.*?)['\"](.*?)>(.*?)</a>",
		Pattern.MULTILINE | Pattern.DOTALL);
	private static final Pattern NEW_LINE_PATTERN = Pattern.compile("[\\n\\r]+");

	public String trim(String text, int trimLength) {
		if (text.length() > trimLength) {
			text = text.substring(0, trimLength);
			text = text.concat("..");
		}
		return text;
	}

	public String escapeIndex(String text) {
		Matcher m = LINK_PATTERN.matcher(text);

		StringBuffer textBuffer = new StringBuffer();
		while (m.find()) {
			String url = m.group(2);
			if (!url.contains("riado")) {

				if ((!url.startsWith("http://")) && (!url.startsWith("https://")))
					url = "http://" + url;

				m.appendReplacement(textBuffer,
					"<noindex><a$1href='" + url + "'$3 rel='nofollow' target='_blank'>$4</a></noindex>");
			}
		}

		m.appendTail(textBuffer);

		return textBuffer.toString();
	}

	public String removeHtml(String text) {
		Matcher m = HTML_PATTERN.matcher(text);
		StringBuffer textBuffer = new StringBuffer();
		while (m.find())
			m.appendReplacement(textBuffer, "");
		m.appendTail(textBuffer);
		return textBuffer.toString();
	}

	public String htmlNL(String text) {
		return NEW_LINE_PATTERN.matcher(text).replaceAll("<br />");
	}

	public String preview(String text) {
		return trim(removeHtml(text), DEFAULT_PREVIEW_TRIM_LENGTH);
	}

	public String feedbackText(String text) {
		return htmlNL(removeHtml(text));
	}

	public String feedbackPreview(String text) {
		return htmlNL(preview(text));
	}

}
