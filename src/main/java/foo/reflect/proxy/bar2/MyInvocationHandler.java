package foo.reflect.proxy.bar2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MyInvocationHandler implements InvocationHandler {

	private static final Logger logger = LoggerFactory.getLogger(MyInvocationHandler.class);

	Object obj; // 被代理类

	// bind directly
	public Object bind(Object object) {
		this.obj = object;
		Object newProxyInstance = Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
		return newProxyInstance;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		logger.info("before invoke");

		Object returnVal = method.invoke(obj, args);

		logger.info("after invoke");

		return returnVal;
	}
}