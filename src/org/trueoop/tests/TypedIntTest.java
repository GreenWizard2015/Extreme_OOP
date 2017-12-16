package org.trueoop.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.trueoop.app.*;

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
	
	@Test
	public void printTitle() {
		final String title = "title for input";
		
		IOutput output = mock(IOutput.class);
		IEnviroment env = mock(IEnviroment.class);
		when(env.input()).thenReturn(mock(IInput.class));
		when(env.output()).thenReturn(output);
		
		IValue<Integer> val = new TypedInt(title);
		val.value(env);
		
		verify(output, times(1)).println(title);
	}
}
