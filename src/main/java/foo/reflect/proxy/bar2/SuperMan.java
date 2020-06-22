package foo.reflect.proxy.bar2;

class SuperMan implements Human {

	@Override
	public void info() {
		System.out.println("I'm a SuperMan...");
	}

	@Override
	public void fly() {
		System.out.println("I can fly...");
	}
}