package org.trueoop.app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		IApplication app = 
			new Application(
				new FormattedText(
					"Estimation of pi = %1.5f (actually is 3.141592)",
					new Estimator(
						new Trial(
							new Dartsboard(
								new HitPoints()
							),
							new Cached<>(
								new TypedInt("How many times should the dart be thrown per trial?")
							)
						),
						new TypedInt("How many trials do you want to simulate?")
					)
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
