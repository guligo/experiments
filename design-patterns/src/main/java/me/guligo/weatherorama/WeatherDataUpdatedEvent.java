package me.guligo.weatherorama;

import me.guligo.weatherorama.ifaces.Event;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class WeatherDataUpdatedEvent implements Event {

	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherDataUpdatedEvent(float temperature, float humidity,
			float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
