package org.trueoop.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.trueoop.app.*;

public class CachedTest {

	@Test
	public void readValueOnlyOnce() {
		final Integer correctValue = 587;
		IValue<Integer> fake = mock(FakeInt.class);
		when(fake.value(any())).thenReturn(correctValue);		

		IValue<Integer> val = new Cached<Integer>(fake);
		for (int i = 0; i < 10; i++) 
			assertEquals(val.value(null), correctValue);
		
		verify(fake, times(1)).value(any());
	}
}
