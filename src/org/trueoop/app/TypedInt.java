package org.trueoop.app;

public class TypedInt implements IValue<Integer> {
	@Override
	public Integer value(IEnviroment env) {
		return env.input().Int();
	}

}
