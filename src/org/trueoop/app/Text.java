package org.trueoop.app;

public class Text implements ITask {

	private final String _text;

	public Text(String txt) {
		this._text = txt;
	}

	@Override
	public void run(IEnviroment env) {
		env.output().Str(_text);
	}
}
