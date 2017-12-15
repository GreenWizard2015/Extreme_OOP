package org.trueoop.app;

import java.util.Scanner;

public class Input implements IInput {

	private final Scanner _scanner;

	public Input(Scanner scanner) {
		this._scanner = scanner;
	}
 
	@Override
	public int Int() {
		return _scanner.nextInt();
	}

}
