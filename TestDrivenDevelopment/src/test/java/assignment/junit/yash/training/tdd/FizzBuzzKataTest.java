package assignment.junit.yash.training.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import yash.trainging.tdd.FizzBuzzKata;

public class FizzBuzzKataTest {

	@Test
	public void shouldReturnFizzIfNumberIsDivisibleBy3() {
		FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
		String actualResult=fizzBuzzKata.takeInputNumber(3);
		assertEquals("Fizz",actualResult );
	}
	
	@Test
	public void shouldReturnBuzzIfNumberIsDivisibleBy5() {
		FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
		String actualResult=fizzBuzzKata.takeInputNumber(5);
		assertEquals("Buzz", actualResult);
	}
	
	@Test
	public void shouldReturnFizzBuzzIfNumberIsDivisibleBy3And5() {
		FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
		String actualResult=fizzBuzzKata.takeInputNumber(15);
		assertEquals("FizzBuzz", actualResult);
	}
	
	@Test
	public void shouldReturnNumber() {
		FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
		String actualResult=fizzBuzzKata.takeInputNumber(17);
		assertEquals("17", actualResult);
	}

}
