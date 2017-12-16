package org.trueoop.tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.trueoop.app.*;

public class TrialTest {

	@Test
	public void hitsSpecificTimes(){
		final int N = 25;
		Dartsboard board = mock(Dartsboard.class);
		IValue<Integer> trialsN = FakeInt.with(N);

		IValue<Double> trial = new Trial(board, trialsN);
		trial.value(null);
		
		verify(board, times(N)).nextHit();
	}

	private void checkAvgTrials(
		final int hits, final int totalN, double answer
	){
		Dartsboard board = mock(Dartsboard.class);
		when(board.nextHit()).then(new Answer() {
			private int ind = -1;
			@Override
			public Boolean answer(InvocationOnMock _) throws Throwable {
				ind++;
				return ind < hits;
			}
		});
		
		IValue<Integer> trialsN = FakeInt.with(totalN);

		IValue<Double> trial = new Trial(board, trialsN);
		assertEquals(answer, trial.value(null), 0.00001);
	}

	@Test
	public void returnAvgTrials(){
		checkAvgTrials(0, 0, 0.0);
		checkAvgTrials(5, 10, 0.5 * 4);
		checkAvgTrials(30, 10, 1.0 * 4);
	}
}
