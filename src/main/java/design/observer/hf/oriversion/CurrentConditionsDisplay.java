package design.observer.hf.oriversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private static final Logger logger = LoggerFactory.getLogger(CurrentConditionsDisplay.class);

	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherDate) {
		this.weatherData = weatherDate;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		logger.info("Current conditions: {} F degrees and {} % humidity.", temperature, humidity);
	}
}
