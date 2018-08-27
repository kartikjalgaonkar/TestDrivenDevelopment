package assignment.junit.yash.training.tdd;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import yash.trainging.tdd.WordCounterKata;

public class WordCounterKataTest {

	@Test
	public void shouldReturnUniqueWordsAndTheirCount() {
		WordCounterKata wordCounterKata = new WordCounterKata();
		Map<String, Long> expectedMap = new HashMap<>();
		expectedMap.put("Boom", (long) 2);
		expectedMap.put("Zoom", (long) 1);
		
		Map<String, Long> actualMap = wordCounterKata.getWordAndItsCount("Boom,Zoom,Boom");
		assertEquals(expectedMap, actualMap);
	}

}
