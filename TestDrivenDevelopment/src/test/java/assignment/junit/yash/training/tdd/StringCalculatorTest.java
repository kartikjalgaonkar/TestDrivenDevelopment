package assignment.junit.yash.training.tdd;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import yash.trainging.tdd.StringCalculator;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {
	
	@Mock
	Logger logger;
	@InjectMocks
	StringCalculator stringCalculator = new StringCalculator();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void shouldReturnZeroWhenInputIsEmptyString() {
		Integer actualResult = stringCalculator.addNumbers("");
		assertEquals(0, actualResult.intValue());
		
	}
	
	@Test
	public void shouldReturnSameNumberIfInputIsSingleNumber(){
		Integer actualResult = stringCalculator.addNumbers("5");
		assertEquals(5, actualResult.intValue());
	}
	
	@Test
	public void shouldReturnSumOfTwoNumbers(){
		Integer actualResult = stringCalculator.addNumbers("1,3");
		assertEquals(4, actualResult.intValue());
	}
	@Test
	public void shouldReturnSumOfMoreThanOneNumbersEparatedWithComma(){
		Integer actualResult = stringCalculator.addNumbers("1,3,45,645,3");
		assertEquals(697, actualResult.intValue());
	}
	
	@Test
	public void shouldReturnSumOfNumbersSeparatedWithNewlineAndComma(){
		Integer actualResult = stringCalculator.addNumbers("1,3,45,645\n3");
		assertEquals(697, actualResult.intValue());
	}
	
	@Test
	public void shouldSupportNewDelimeterWhileAddingNumbers(){
		Integer actualResult = stringCalculator.addNumbers("//;\n1;3;45;645;3");
		assertEquals(697, actualResult.intValue());
	}
	
	@Test
	public void shouldIgnoreThousand(){
		Integer actualResult = stringCalculator.addNumbers("//;\n1;3;45;645;3;1001");
		assertEquals(697, actualResult.intValue());
	}
	
	@Test
	public void shouldLogSumWhenAddIsCalled(){
		Mockito.doNothing().when(logger).info("697");
		stringCalculator.addNumbers("//;\n1;3;45;645;3;1001");
		Mockito.verify(logger).info("697");
	}
	
	@Test
	public void shouldThrowExceptionIfNegativeInputIsGiven(){
		
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Negative numbers not allowed:[-45, -3]");
		stringCalculator.addNumbers("//;\n1;3;-45;645;-3;1001");
	}
	
	/*@Test(expected=NumberFormatException.class)
	public void shouldThrowExceptionIfInvalidInputIsGiven(){
		stringCalculator.addNumbers("2,asdf,13");
	}*/

}
