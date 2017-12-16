package org.trueoop.tests;

import static org.mockito.Mockito.*;
import org.trueoop.app.IValue;

abstract class FakeInt implements IValue<Integer>{

	public static IValue<Integer> with(int value) {
		IValue<Integer> fake = mock(FakeInt.class);
		when(fake.value(any())).thenReturn(value);
		return fake;
	}		
}