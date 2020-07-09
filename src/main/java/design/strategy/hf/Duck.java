package design.strategy.hf;

public abstract class Duck {

	// XXX
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

	// XXX
	abstract void display();

	// XXX
	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}