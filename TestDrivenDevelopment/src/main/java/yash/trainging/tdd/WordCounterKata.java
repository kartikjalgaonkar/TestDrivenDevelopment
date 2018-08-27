package yash.trainging.tdd;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounterKata {
	public Map<String, Long> getWordAndItsCount(String input) {
		List<String> listOfWords = Arrays.asList(input.split(","));
		return listOfWords.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	}

}
