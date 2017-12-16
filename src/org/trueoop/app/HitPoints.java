package org.trueoop.app;

import java.util.Random;

public class HitPoints implements IHitPoints {

	private final Random _rnd = new Random();
	
	@Override
	public IHitPoint next() {
		return new HitPoint(rnd(), rnd());
	}

	private double rnd() {
		return (2 * _rnd.nextDouble()) - 1.0;
	}
}
