package org.trueoop.app;

public class Enviroment implements IEnviroment {

	private final IInput _input;
	private final IOutput _output;

	public Enviroment(IInput input, IOutput output) {
		this._input = input;
		this._output = output;
	}

	@Override
	public IInput input() {
		return _input;
	}

	@Override
	public IOutput output() {
		return _output;
	}

}
