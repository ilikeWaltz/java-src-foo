package design.strategy.hf;

public class RubberDuck extends Duck {

	public RubberDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new Squeak());
	}

	@Override
	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}
