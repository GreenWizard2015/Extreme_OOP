package org.trueoop.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import org.trueoop.app.*;

import junit.framework.Assert;

public class ApplicationTest {

	@Test
	public void shouldntCrashIfNoTask() {
		IApplication app = new Application();
		app.run(null);
	}

	@Test
	public void executeTaskOnce() {
		ITask task = mock(ITask.class);
		IApplication app = new Application(task);
		app.run(null);
		verify(task, times(1)).run();
	}

	@Test
	public void pullInput() {
		final int val = 4778;
		IInput input = mock(IInput.class);
		when(input.Int()).thenReturn(val);
		
		ITask task = mock(ITask.class);
		doAnswer((Answer) inv -> {
			Object[] args = inv.getArguments();
			IEnviroment env = (IEnviroment)args[0];
			assertEquals(val, env.input().Int());
		}).when(task).run();
		
		IApplication app = new Application(task);
		app.run(null);
		
		verify(input, times(1)).Int();
	}
}
