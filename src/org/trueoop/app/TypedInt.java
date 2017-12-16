package org.trueoop.app;

public class TypedInt implements IValue<Integer> {
	private final String _title;

	public TypedInt(String title) {
		this._title = title;
	}

	public TypedInt() {
		this(null);
	}

	@Override
	public Integer value(IEnviroment env) {
		if(null != _title)
			env.output().println(_title);
		return env.input().Int();
	}

}
