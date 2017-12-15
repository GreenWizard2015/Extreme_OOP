package org.trueoop.tests;

import org.trueoop.app.IEnviroment;
import org.trueoop.app.IInput;

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
