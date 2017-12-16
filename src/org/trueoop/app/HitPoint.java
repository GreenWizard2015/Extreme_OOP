package org.trueoop.app;

public class HitPoint implements IHitPoint {

	private double _x;
	private double _y;

	public HitPoint(double x, double y) {
		this._x = x;
		this._y = y;
	}

	@Override
	public double dist() {
		return Math.sqrt(Math.pow(_x, 2.0) + Math.pow(_y, 2.0));
	}

}
