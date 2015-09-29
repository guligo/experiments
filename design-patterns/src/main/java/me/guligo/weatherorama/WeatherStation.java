package me.guligo.weatherorama;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay display = new CurrentConditionsDisplay(
				weatherData);

		weatherData.setMeasurements(1, 2, 3);
	}

}
