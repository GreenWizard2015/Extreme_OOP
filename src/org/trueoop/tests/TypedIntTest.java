package org.trueoop.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.InvalidValue;
import org.trueoop.app.IEnviroment;
import org.trueoop.app.IInput;
import org.trueoop.app.IValue;
import org.trueoop.app.TypedInt;

public class TypedIntTest {

	@Test
	public void readCorrectValue() {
		final Integer correctValue = 587;
		IInput input = mock(IInput.class);
		when(input.Int()).thenReturn(correctValue);
		
		IEnviroment env = mock(IEnviroment.class);
		when(env.input()).thenReturn(input);
		
		IValue<Integer> val = new TypedInt();
		assertEquals(val.value(env), correctValue);
		
		verify(input, times(1)).Int();
	}
}
