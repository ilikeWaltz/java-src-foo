package foo.reflect.proxy.bar1;

public class TestAOP {

	public static void main(String[] args) {

		SuperMan man = new SuperMan(); // 被代理实例

		Object obj = MyProxy.getProxyInstance(man); // 代理实例

		Human human = (Human) obj;

		human.info();
		human.fly();
	}
}