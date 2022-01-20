package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

// A Stub impl makes your unit tests not dependant on actual DB instances.
//
// Disadvantages of Stubs are:
//   - Hundreds of classes would, in theory, explode.
//   - Maintainability is a big headache
//   - If a new method is added to the main interface, all stub classes would need updating.
//   -
//   -
class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3 };
	}
}

class SomeDataServiceEmptyStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { };
	}
}

class SomeDataServiceOneElementStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 5 };
	}
}

class SomeBusinessStubTest {

	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();//new int[] {}
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDataService();//new int[] { 5 }
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}
