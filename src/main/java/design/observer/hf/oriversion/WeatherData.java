package design.observer.hf.oriversion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherData implements Subject {

	private static final Logger logger = LoggerFactory.getLogger(WeatherData.class);

	private List<Observer> observers;

	public WeatherData() {
		observers = new ArrayList<>();
	}

	private float temperature;
	private float humidity;
	private float pressure;

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);
	}

	@Override
	public void notivyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}

	public void measurementsChanged() {
		notivyObservers();
	}

	public void setMeasurements(float tempreature, float humidity, float pressure) {
		this.temperature = tempreature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
