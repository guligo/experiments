package me.guligo.weatherorama;

import me.guligo.weatherorama.ifaces.Display;
import me.guligo.weatherorama.ifaces.Observer;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class GeneralDisplay implements Observer<WeatherDataUpdatedEvent>,
		Display {

	private float temperature;

	public GeneralDisplay() {
		temperature = 0;
	}

	@Override
	public void update(WeatherDataUpdatedEvent event) {
		temperature = event.getTemperature();

		display();
	}

	@Override
	public void display() {
		System.out.println("==========");
		System.out.println("Displaying general information:");
		if (temperature > 15) {
			System.out.println("It's nice weather today!");
		} else {
			System.out.println("It could have been much better...");
		}
		System.out.println("==========");
	}

}
