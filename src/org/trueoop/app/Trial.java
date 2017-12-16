package org.trueoop.app;

public class Trial implements IValue<Double> {

	private final Dartsboard _board;
	private final IValue<Integer> _trialsN;

	public Trial(Dartsboard board, IValue<Integer> trialsN) {
		this._board = board;
		this._trialsN = trialsN;
	}

	@Override
	public Double value(IEnviroment env) {
		final int N = _trialsN.value(env);
		int hitted = 0;
		for (int i = 0; i < N; i++) {
			if(_board.nextHit())
				hitted++;
		}
		if(0 < N)
			return (double)hitted / N;
		
		return 0.0;
	}

}
