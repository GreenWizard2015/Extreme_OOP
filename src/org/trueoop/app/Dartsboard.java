package org.trueoop.app;

public class Dartsboard {

	private final IHitPoints _points;

	public Dartsboard(IHitPoints pts) {
		this._points = pts;
	}

	public boolean nextHit() {
		return _points.next().dist() <= 1.0;
	}
}
