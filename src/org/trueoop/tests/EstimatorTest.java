package org.trueoop.tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.trueoop.app.*;

public class EstimatorTest {

	private void returnZeroTest(int N) {
		IValue<Integer> trialsN = mock(FakeInt.class);
		when(trialsN.value(any())).thenReturn(0);
		
		IValue<Double> est = new Estimator(trialsN);
		assertSame(0.0, est.value(null));
	}
	
	@Test
	public void returnZeroIfLessThanOneTrial() {
		returnZeroTest(0);
		returnZeroTest(-1);
	}
}
