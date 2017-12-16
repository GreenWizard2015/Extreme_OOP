package org.trueoop.app;

public class Cached<T> implements IValue<T> {

	private final IValue<T> _value;
	private T _cached = null; // bad idea
	
	public Cached(IValue<T> _value) {
		this._value = _value;
	}

	@Override
	public T value(IEnviroment env) {
		if(null == _cached)
			_cached = _value.value(env);
			
		return _cached;
	}

}
