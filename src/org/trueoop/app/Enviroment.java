package org.trueoop.app;

public class Enviroment implements IEnviroment {

	private IInput _input;

	public Enviroment(IInput input) {
		this._input = input;
	}

	@Override
	public IInput input() {
		return _input;
	}

}
