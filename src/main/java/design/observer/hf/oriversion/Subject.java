package design.observer.hf.oriversion;

public interface Subject {

	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notivyObservers();
}
