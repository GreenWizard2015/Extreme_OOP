package org.trueoop.app;

public class FormattedText implements ITask {

	private final String _format;
	private final IValue<?>[] _values;

	public FormattedText(String format, IValue<?>... values) {
		this._format = format;
		this._values = values;
	}

	@Override
	public void run(IEnviroment enviroment) {
		Object[] args = new Object[_values.length];
		for (int i = 0; i < args.length; i++) {
			args[i] = _values[i].value(enviroment);
		}

		enviroment.output().println(
			String.format(_format, args)
		);
	}

}
