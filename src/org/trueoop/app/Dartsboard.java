package org.trueoop.app;

public class Dartsboard {

	private final IHitPoints _points;

	public Dartsboard(IHitPoints pts) {
		this._points = pts;
	}

	public boolean nextHit() {
		return false;
	}

}
