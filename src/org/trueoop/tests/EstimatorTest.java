package org.trueoop.tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.trueoop.app.*;

public class EstimatorTest {

	private void returnZeroTest(int N) {
		IValue<Integer> trialsN = mock(FakeInt.class);
		when(trialsN.value(any())).thenReturn(0);
		
		IValue<Double> est = new Estimator(null, trialsN);
		assertEquals(0.0, est.value(null), 0.000001);
	}
	
	@Test
	public void returnZeroIfLessThanOneTrial() {
		returnZeroTest(0);
		returnZeroTest(-1);
	}
	
	@Test
	public void runTrialsSpecificTimes(){
		final int N = 25;
		IValue<Double> trial = mock(Trial.class);
		
		IValue<Integer> trialsN = mock(FakeInt.class);
		when(trialsN.value(any())).thenReturn(N);
		
		IValue<Double> est = new Estimator(trial, trialsN);
		est.value(null);
		
		verify(trial, times(N)).value(any());
	}
	
	@Test
	public void returnAvgTrials(){
		final Double[] data = new Double[]{
			3.0, -7.0, 5.0, 13.0, -2.0
		};
		final Double avg = 2.4;
		
		IValue<Double> trial = mock(Trial.class);
		when(trial.value(any())).then(new Answer<Double>() {
			private int ind = -1;
			@Override
			public Double answer(InvocationOnMock _) throws Throwable {
				ind++;
				return data[ind];
			}
		});
		
		IValue<Integer> trialsN = mock(FakeInt.class);
		when(trialsN.value(any())).thenReturn(data.length);
		
		IValue<Double> est = new Estimator(trial, trialsN);
		assertEquals(avg, est.value(null), 0.00001);

		verify(trial, times(data.length)).value(any());
		verify(trialsN, times(1)).value(any());
	}
}
