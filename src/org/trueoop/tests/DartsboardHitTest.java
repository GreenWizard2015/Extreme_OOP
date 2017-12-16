package org.trueoop.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import org.trueoop.app.*;

@RunWith(value = Parameterized.class)
public class DartsboardHitTest {
	@Parameter(0)
	private double _dist;
	@Parameter(1)
	private boolean _answer;

  @Parameters(name = "{index}: dist {0} => {1})")
  public static Collection<Object[]> data() {
  	final double STEP = 0.05;
  	List<Object[]> res = new ArrayList<>();
  	for (double i = 0.0; i < 1.5; i += STEP) {
			res.add(new Object[]{i, i <= 1});
		}
		return res;
  }
	
	@Test
	public void correctlyCheckHits() {
		IHitPoint pt = mock(IHitPoint.class);
		when(pt.dist()).thenReturn(_dist);
		
		IHitPoints pts = mock(IHitPoints.class);
		when(pts.next()).thenAnswer(pt);
		
		Dartsboard board = new Dartsboard(pts);
		assertEquals(_answer, board.nextHit());

		verify(pt, times(1)).dist();
		verify(pts, times(1)).next();
		verifyNoMoreInteractions(pt, pts);
	}
}
