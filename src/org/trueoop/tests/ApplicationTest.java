package org.trueoop.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;
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

}
