package design.observer;

/**
 * 主题
 */
public interface Subject {

	void registerObserver(Observer observer);

	void removeObserver(Observer obs);

	void notifyObservers(String msg);

	void setState(int state);

	int getState();
}