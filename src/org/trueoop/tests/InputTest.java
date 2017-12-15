package org.trueoop.tests;

import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Matchers.same;
import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;

import java.util.Scanner;
import org.trueoop.app.IInput;
import org.trueoop.app.Input;

public class InputTest {

	@Test
	@Ignore("Can't mock Scanner")
	public void readInt() {
		final int value = 6765;
		
		Scanner scanner = mock(Scanner.class);
		when(scanner.nextInt()).thenReturn(value);
		
		IInput input = new Input(scanner);
		assertEquals(value, input.Int());

		verify(scanner, times(1)).nextInt();
		verifyNoMoreInteractions(scanner);
	}
}