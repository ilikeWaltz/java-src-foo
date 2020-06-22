package foo.reflect;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.lang.Class<T>
// 
// 
public class ClassFoo {

	private static final Logger logger = LoggerFactory.getLogger(ClassFoo.class);

	public static void main(String[] args) {
		Class<Dio> classDio = Dio.class;
		logger.info("{}", classDio.getName());

		Constructor<?>[] constructors = classDio.getConstructors();
		for (Constructor<?> constructor : constructors) {
			logger.info("{}", constructor);
		}
	}
}
