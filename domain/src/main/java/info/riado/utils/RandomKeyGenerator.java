package info.riado.utils;

import java.util.Random;

/**
 * @author ivan
 */
public class RandomKeyGenerator {
	public static final char[] VALID_URL_SYMBOLS = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
		'-', '_'
	};

	private static final ThreadLocal<Random> RANDOM = new ThreadLocal<Random>() {
		@Override
		protected Random initialValue() {
			return new Random();
		}
	};

	public static String generateKey(char[] symbolsDictionary, int keyLength) {
		StringBuilder key = new StringBuilder(keyLength);
		for (int i = 0; i < keyLength; i++)
			key.append(symbolsDictionary[RANDOM.get().nextInt(symbolsDictionary.length)]);

		return key.toString();
	}
}
