package design.strategy.hf;


public class RedHeadDuck extends Duck {
 
	public RedHeadDuck() {
		setFlyBehavior(new FlyWithWings());
		setQuackBehavior( new Quack());
	}
 
	@Override
	public void display() {
		System.out.println("I'm a real Red Headed duck");
	}
}
