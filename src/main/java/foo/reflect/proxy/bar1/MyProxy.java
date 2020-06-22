package foo.reflect.proxy.bar1;

import java.lang.reflect.Proxy;

class MyProxy {

	// 动态的创建一个代理类的对象
	public static Object getProxyInstance(Object obj) {

		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setObject(obj);

		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
	}
}