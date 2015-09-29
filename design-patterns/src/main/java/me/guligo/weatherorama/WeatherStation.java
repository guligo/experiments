package me.guligo.weatherorama;

/**
 * Following is an example of push-based observer pattern. The
 * "observer pattern" defines a one-to-many dependency between objects so that
 * when one object changes state, all of its dependents are notified and updated
 * automatically.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class WeatherStation {

	public static void main(String[] args) {
		GeneralDisplay generalDisplay = new GeneralDisplay();
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

		WeatherData weatherData = new WeatherData();
		weatherData.registerObserver(generalDisplay);
		weatherData.registerObserver(statisticsDisplay);
		weatherData.setMeasurements(1, 2, 3);
		weatherData.setMeasurements(4, 5, 6);
		weatherData.removeObserver(statisticsDisplay);
		weatherData.setMeasurements(7, 8, 9);
	}

}
