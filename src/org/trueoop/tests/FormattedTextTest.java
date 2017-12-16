package org.trueoop.tests;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.trueoop.app.*;

public class FormattedTextTest {
	
	@Test
	public void formatInts() {
		final String fmt = "TeXt %d";
		final int value = 467;
		final String correctStr = String.format(fmt, value);
		
		IOutput output = mock(IOutput.class);
		IEnviroment env = mock(IEnviroment.class);
		when(env.output()).thenReturn(output);

		IValue<Integer> fakeInt = FakeInt.with(value);
		
		ITask task = new FormattedText(fmt, fakeInt);
		task.run(env);

		verify(env, times(1)).output();
		verify(output, times(1)).println(correctStr);
		verifyNoMoreInteractions(env, output);
	}
}
