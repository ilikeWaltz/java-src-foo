package foo.reflect.proxy.bar1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MyInvocationHandler implements InvocationHandler {

	private static final Logger logger = LoggerFactory.getLogger(MyInvocationHandler.class);

	Object obj; // 被代理类对象

	// or in constructor
	public void setObject(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		logger.info("before invoke");

		Object returnVal = method.invoke(obj, args);

		logger.info("after invoke");

		return returnVal;
	}
}