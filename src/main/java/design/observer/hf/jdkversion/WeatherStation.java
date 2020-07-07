package design.observer.hf.jdkversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherStation {

	private static final Logger logger = LoggerFactory.getLogger(WeatherStation.class);

	public static void main(String[] args) {

		// subject
		WeatherData weatherData = new WeatherData();

		// observer
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

		weatherData.setMeasurements(1, 2, 3);
	}
}