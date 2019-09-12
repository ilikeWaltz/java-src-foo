package foo;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.lang.Object

// int java.lang.Object.hashCode()

// void java.lang.Object.wait() throws InterruptedException
// 

public class ObjectFoo {

	private static final Logger logger = LoggerFactory.getLogger(ObjectFoo.class);

	public static void main(String[] args) throws InterruptedException {

		Object object = new Object();

		int hashCode = object.hashCode();
		logger.info("object.hashCode(): {}", hashCode);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.MINUTES.sleep(1);
				} catch (InterruptedException e) {
					logger.error("", e);
				}
				synchronized (object) {
					logger.info("object.notify() start!");
					object.notify();
					logger.info("object.notify() end!");
				}
			}
		}).start();

		synchronized (object) {
			logger.info("object.wait() start!");
			object.wait();
			logger.info("object.wait() end!");
		}

	}
}
