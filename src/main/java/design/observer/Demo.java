package design.observer;

public class Demo {

	public static void main(String[] args) {

		ConcreteSubject sub = new ConcreteSubject();
		ConcreteObserver obs = new ConcreteObserver();

		sub.registerObserver(obs);
		sub.setState(666);

		sub.notifyObservers("just test subject notify function!");
	}
}