package me.guligo.weatherorama;

import java.util.ArrayList;
import java.util.List;

import me.guligo.weatherorama.ifaces.Observer;
import me.guligo.weatherorama.ifaces.Subject;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class WeatherData implements Subject<WeatherDataUpdatedEvent> {

	private List<Observer<WeatherDataUpdatedEvent>> observers;

	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList<>();

		temperature = 0;
		humidity = 0;
		pressure = 0;
	}

	@Override
	public void registerObserver(Observer<WeatherDataUpdatedEvent> observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer<WeatherDataUpdatedEvent> observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer<WeatherDataUpdatedEvent> observer : observers) {
			observer.update(new WeatherDataUpdatedEvent(temperature, humidity,
					pressure));
		}
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity,
			float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		measurementsChanged();
	}

}
