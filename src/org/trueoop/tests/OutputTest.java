package org.trueoop.tests;

import java.io.PrintStream;

import org.junit.Test;
import static org.mockito.Mockito.*;
import org.trueoop.app.Output;

public class OutputTest {

	@Test
	public void printText() {
		final String txt = "text";
		PrintStream stream = mock(PrintStream.class);
		
		Output output = new Output(stream);
		output.println(txt);

		verify(stream, times(1)).println(same(txt));
		verifyNoMoreInteractions(stream);
	}
}
