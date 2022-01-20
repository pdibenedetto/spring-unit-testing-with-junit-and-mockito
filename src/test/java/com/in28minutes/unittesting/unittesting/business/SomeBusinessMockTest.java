package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SomeBusinessMockTest {

	// Mock out Some Data Service that lives in SomeBusinessImpl
    SomeBusinessImpl businessService;
    SomeDataService repositoryMock;

    @BeforeEach
    void setUp() {
        this.businessService = new SomeBusinessImpl();
        this.repositoryMock = mock(SomeDataService.class);
        this.businessService.setSomeDataService(this.repositoryMock);
    }

    @Test
    void calculateSumUsingDataService_basic() {
		// given
		// when
		when(repositoryMock.retrieveAllData()).thenReturn(new int [] { 1, 2, 3 });

		// then
        int actualSumResult = businessService.calculateSumUsingDataService();
        assertEquals(6, actualSumResult);
    }

    @Test
    void calculateSumUsingDataService_empty() {
        // given
        // when
        when(repositoryMock.retrieveAllData()).thenReturn(new int[]{});

        // then
        int actualSumResult = businessService.calculateSumUsingDataService();
        assertEquals(0, actualSumResult);

    }

    @Test
    void calculateSumUsingDataService_oneValue() {
        // given
        // when
        when(repositoryMock.retrieveAllData()).thenReturn(new int [] { 3 });

        // then
        int actualSumResult = businessService.calculateSumUsingDataService();
        assertEquals(3, actualSumResult);
    }
}
