package com.in28minutes.unittesting.unittesting.spike;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.Matchers.isEmptyString; // Deprecated and works for Spring Boot 3
import static org.hamcrest.Matchers.*; // For Spring Boot 4
import static org.hamcrest.text.IsEmptyString.emptyString; // For Spring Boot 4

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {
	
	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,15,45);
		
		assertThat(numbers, hasSize(3));
		assertThat(numbers, hasItems(12,45));
		assertThat(numbers, everyItem(greaterThan(10)));
		assertThat(numbers, everyItem(lessThan(100)));
		
		// assertThat("", isEmptyString());// for spring boot 3
		assertThat("", is(emptyString())); // for spring boot 4
		assertThat("ABCDE", containsString("BCD"));
		assertThat("ABCDE", startsWith("ABC"));
		assertThat("ABCDE", endsWith("CDE"));
				
	}

}
