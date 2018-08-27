package assignment.junit.yash.training.tdd;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import yash.trainging.tdd.PasswordVarifier;

public class PasswordVarifierTest {
	PasswordVarifier passwordVerifier = new PasswordVarifier();
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void shouldHaveLenghtLargerThanEight() {
		boolean actualResult=passwordVerifier.verify("Yashes");
		assertEquals(true, actualResult);
	}

	@Test
	public void shouldThrowPasswordCanNotBeNullException() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password cannot be null");
		PasswordVarifier passwordVerifier = new PasswordVarifier();
		passwordVerifier.verify(null);
	}

	@Test
	public void shouldHaveAtLeastOneUpperCaseLetter() {
		boolean actualResult=passwordVerifier.verify("YashTechologies1");
		assertEquals(true, actualResult);
	}

	@Test
	public void shouldThrowExceptiomIfNoLowerCaseLetterIsPresent() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password must contain atleast one small letter");
		passwordVerifier.verify("PASSWORD");
	}

	@Test
	public void shouldHaveAtLeastOneLowerCaseLetter() {
		boolean actualResult=passwordVerifier.verify("YashTechologies1");
		assertEquals(true, actualResult);
	}

	@Test
	public void shouldHaveAtLeastOneNumber() {
		boolean actualResult=passwordVerifier.verify("YashTechologies1");
		assertEquals(true, actualResult);
	}

	@Test
	public void shouldThrowExceptionIfPasswordCriteriaDoesNotMatch() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Password is not OK");
		passwordVerifier.verify("asdf");
	}

}
