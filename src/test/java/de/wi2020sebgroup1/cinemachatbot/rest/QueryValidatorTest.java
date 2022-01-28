package de.wi2020sebgroup1.cinemachatbot.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QueryValidatorTest {
	
	@Test
	void testIsDate() {

		assertEquals(true, QueryValidator.isDate("28. Oktober 2022"));
		assertEquals(false, QueryValidator.isDate("32. Oktober 2022"));
		assertEquals(true, QueryValidator.isDate("12/24/2021"));
		assertEquals(false, QueryValidator.isDate("13/24/2021"));
		assertEquals(true, QueryValidator.isDate("October 1st 2022"));
		assertEquals(true, QueryValidator.isDate("Juno 2 2038"));
		assertEquals(true, QueryValidator.isDate("27. 3"));
		
	}
	
}
