package design.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

	private List<Observer> observerList = new ArrayList<Observer>();

	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers(String msg) {
		for (Observer obs : observerList) {
			obs.update(msg);
		}
	}

	private int state;

	@Override
	public void setState(int state) {
		this.state = state;
		notifyObservers("new state: " + state);
	}

	@Override
	public int getState() {
		return 0;
	}
}