package design.observer.hf.jdkversion;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import design.observer.hf.oriversion.DisplayElement;

/**
 * 
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private static final Logger logger = LoggerFactory.getLogger(CurrentConditionsDisplay.class);

	private Observable observable;

	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		this.observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	@Override
	public void display() {
		logger.info("Current conditions: {} F degrees and {} % humidity.", temperature, humidity);
	}

}
