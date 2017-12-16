package org.trueoop.app;

public class Estimator implements IValue<Double> {

	private IValue<Double> _trial;
	private IValue<Integer> _trialsN;

	public Estimator(IValue<Double> trial, IValue<Integer> trialsN) {
		this._trial = trial;
		this._trialsN = trialsN;
	}

	@Override
	public Double value(IEnviroment env) {
		final int N = _trialsN.value(env);
		Double res = 0.0;
		for (int i = 0; i < N; i++) {
			res += _trial.value(env);
		}
		if(0 < N)
			res /= N;
		return res;
	}

}
