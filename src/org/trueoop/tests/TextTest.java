package org.trueoop.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.trueoop.app.IEnviroment;
import org.trueoop.app.IInput;
import org.trueoop.app.IOutput;
import org.trueoop.app.ITask;
import org.trueoop.app.Text;

public class TextTest {

	@Test
	public void printText() {
		final String txt = "unchanged TeXt";
		IOutput output = mock(IOutput.class);
		IEnviroment env = mock(IEnviroment.class);
		when(env.output()).thenReturn(output);
				
		ITask task = new Text(txt);
		task.run(env);

		verify(env, times(1)).output();
		verify(output, times(1)).println(txt);
		verifyNoMoreInteractions(env, output);
	}

}
