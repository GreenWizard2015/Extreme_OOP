package org.trueoop.app;

import java.io.PrintStream;

public class Output implements IOutput {

	private final PrintStream _stream;

	public Output(PrintStream stream) {
		this._stream = stream;
	}

	@Override
	public void println(String txt) {
		_stream.println(txt);
	}
}
