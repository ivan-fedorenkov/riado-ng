package info.riado.utils;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author ivan
 */
public class RandomKeyGeneratorTest {
	@Test
	public void testRandomKeyLength() {
		assertEquals("Random key length invalid", 10, RandomKeyGenerator.generateKey(RandomKeyGenerator.VALID_URL_SYMBOLS, 10).length());
	}

	@Test
	public void testKeyDictionary() {
		char[] keyDictionary = {'a', 'b', 'c'};
		int keyLength = 10;
		String randomKey = RandomKeyGenerator.generateKey(keyDictionary, keyLength);
		for (char ch : randomKey.toCharArray()) {
			assertTrue("Generated key contains invalid symbol", Arrays.binarySearch(keyDictionary, ch) >= 0);
		}
	}
}
