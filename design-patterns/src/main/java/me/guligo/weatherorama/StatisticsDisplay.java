package me.guligo.weatherorama;

import me.guligo.weatherorama.ifaces.Display;
import me.guligo.weatherorama.ifaces.Observer;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class StatisticsDisplay implements Observer<WeatherDataUpdatedEvent>,
		Display {

	private float temperature;
	private float humidity;
	private float pressure;

	public StatisticsDisplay() {
		temperature = 0;
		humidity = 0;
		pressure = 0;
	}

	@Override
	public void update(WeatherDataUpdatedEvent event) {
		temperature = event.getTemperature();
		humidity = event.getHumidity();
		pressure = event.getPressure();

		display();
	}

	@Override
	public void display() {
		System.out.println("##########");
		System.out.println("Displaying statistics:");
		System.out.println("Temperature: " + temperature + " degrees");
		System.out.println("Humidity: " + humidity + " %");
		System.out.println("Pressure: " + pressure + " atm");
		System.out.println("##########");
	}

}
