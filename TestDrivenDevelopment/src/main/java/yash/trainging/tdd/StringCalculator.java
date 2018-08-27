package yash.trainging.tdd;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StringCalculator {

	private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public Integer addNumbers(String input) {

		Integer sum = 0;
		String delimeter = null;
		if (input.startsWith("//")) {
			delimeter = input.substring(2, 3);
			input = input.substring(input.indexOf("\n") + 1);
		}
		if (input.length() != 0) {
			List<String> listOfNumbers = Arrays.asList(input.split("\n|,|" + delimeter));

			List<Integer> listOfNegativeNumbers = listOfNumbers.stream().map(number -> Integer.parseInt(number))
					.filter(n -> n < 0).collect(Collectors.toList());

			if (listOfNegativeNumbers.size() > 0) {
				throw new RuntimeException("Negative numbers not allowed:" + listOfNegativeNumbers);
			}

			sum = listOfNumbers.stream().map(number -> Integer.parseInt(number)).filter(n -> n <= 1000)
					.collect(Collectors.reducing((firstNumber, secondNumber) -> firstNumber + secondNumber)).get();

		}
		logger.info("" + sum);
		return sum;
	}

}
