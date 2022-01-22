package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.internal.matchers.Null;

class ListMockTest {

	List<String> listMock = mock(List.class);

	@Test
	void sizeBasic() {
		when(listMock.size()).thenReturn(3);
		assertEquals(listMock.size(), 3);
	}

	@Test
	void returnDifferentValues() {
		when(listMock.size()).thenReturn(3).thenReturn(6);
		assertEquals(listMock.size(), 3);
		assertEquals(listMock.size(), 6);;
	}

	@Test
	void returnWithParameters() {
		when(listMock.get(0)).thenReturn("mocking with parameters");
		assertEquals("mocking with parameters", listMock.get(0));
		assertNull(listMock.get(1));
	}

	@Test
	void returnWithGenericParameters() {
		when(listMock.get(ArgumentMatchers.anyInt())).thenReturn("mocking with parameters");
		assertEquals("mocking with parameters", listMock.get(0));
		assertEquals("mocking with parameters", listMock.get(5));
		assertNotNull(listMock.get(100));
	}

	@Test
	void verificationBasics() {
		// SUT - System Under Test
		String string1 = listMock.get(0);
		String string2 = listMock.get(1);

		// Verify
		verify(listMock).get(0); 											// <====> verify(listMock, times(1)).get(0);
		verify(listMock, times(2)).get(anyInt());
		verify(listMock, atLeast(2)).get(anyInt());
		verify(listMock, atLeastOnce()).get(anyInt());
		verify(listMock, atMost(2)).get(anyInt());
		verify(listMock, never()).get(100);
	}

	@Test
	void argumentCapturing() {
		// Verify methods were called with specific values
		// SUT
		String s1 = "string 2";
		listMock.add(s1);

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(listMock).add(captor.capture());
		assertEquals(s1, captor.getValue());
	}
	
	@Test
	void multipleArgumentCapturing() {
		// Verify methods were called with specific values
		// SUT
		String s1 = "string 1";
		String s2 = "string 2";
		listMock.add(s1);
		listMock.add(s2);

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		verify(listMock, times(2)).add(captor.capture());

		List<String> strings = captor.getAllValues();
		assertEquals(s1, strings.get(0));
		assertEquals(s2, strings.get(1));
	}

	@Test
	void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		arrayListMock.get(0);			// null
		arrayListMock.size(); 			// 0
		arrayListMock.add("Test 1");
		arrayListMock.add("Test 2");
		arrayListMock.size(); 			// 0 - because the mock isn't the real class of Array List
		assertEquals(0, arrayListMock.size());

		when(arrayListMock.size()).thenReturn(2);
		assertEquals(2, arrayListMock.size());
	}

	@Test
	void spying() {
		// Spy actually retains the classes behavior
		ArrayList arrayListMock = spy(ArrayList.class);
		assertThrows(IndexOutOfBoundsException.class, () -> arrayListMock.get(0));			// null
//		arrayListMock.size(); 			// 0
//		arrayListMock.add("Test 1");
//		arrayListMock.add("Test 2");
//		arrayListMock.size(); 			// 0 - because the mock isn't the real class of Array List
//		assertEquals(0, arrayListMock.size());
//
//		when(arrayListMock.size()).thenReturn(2);
//		assertEquals(2, arrayListMock.size());

	}

	
}
