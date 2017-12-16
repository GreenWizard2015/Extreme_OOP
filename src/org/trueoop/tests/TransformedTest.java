package org.trueoop.tests;

import static org.mockito.Mockito.*;

import java.util.function.Function;

import static org.junit.Assert.*;

import org.junit.Test;
import org.trueoop.app.*;

public class TransformedTest {

	private abstract class IntFunc implements
		Function<Integer, Integer>{
	}
	
	@Test
	public void executeAction() {
		final int value = 5;
		final int value2 = 45;
		
		IntFunc callback = mock(IntFunc.class);
		when(callback.apply(value)).thenReturn(value2);		
		IValue<Integer> fake = FakeInt.with(value);
		
		IValue<Integer> trans = new Transformed<>(callback, fake);
		assertSame(value2, trans.value(null));
		
		verify(callback, times(1)).apply(value);
	}

}
