package design.observer.hf.jdkversion;

import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * subject in original version
 */
public class WeatherData extends Observable {

	private static final Logger logger = LoggerFactory.getLogger(WeatherData.class);

	private float temperature;
	private float humidity;
	private float pressure;

	public void measurementsChanged() {
		// XXX
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float tempreature, float humidity, float pressure) {
		this.temperature = tempreature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	// XXX
	// provide get method instead of update (pull instead of push)
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
