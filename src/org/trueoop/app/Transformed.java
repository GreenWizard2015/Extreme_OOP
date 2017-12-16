package org.trueoop.app;

import java.util.function.Function;

public class Transformed<T, R> implements IValue<R> {

	private final Function<T, R> _callback;
	private final IValue<T> _val;

	public Transformed(Function<T, R> callback, IValue<T> val) {
		this._callback = callback;
		this._val = val;
	}

	@Override
	public R value(IEnviroment env) {
		return _callback.apply(_val.value(env));
	}
}