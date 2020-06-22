package foo.reflect.proxy.bar2;

public class TestAOP {

	public static void main(String[] args) {

		Human human = new SuperMan(); // 被代理实例
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

		Human humanProxy = (Human) myInvocationHandler.bind(human); // 代理实例
		humanProxy.info();
		humanProxy.fly();
	}
}