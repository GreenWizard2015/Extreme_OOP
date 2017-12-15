package org.trueoop.app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		IApplication app = new Application(
			new FormattedText(
				"A = %d, B = %d",
				new TypedInt("Input A:"),
				new TypedInt("Input B:")
			)
		);
		
		app.run(
			new Enviroment(
				new Input(new Scanner(System.in)), 
				new Output(System.out)
			)
		);
	}
}
