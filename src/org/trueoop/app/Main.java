package org.trueoop.app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		IValue<Double> Pi =
			new Cached<>(
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
			);
			
		IApplication app = 
			new Application(
				new FormattedText(
					"Estimation of pi = %1.5f (actually is 3.141592, diff = %.5f)",
					Pi,
					new Transformed<>(
						x -> Math.abs(x - 3.141592),
						Pi
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
