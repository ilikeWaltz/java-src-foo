package foo;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadlockFoo {

	private static final Logger logger = LoggerFactory.getLogger(DeadlockFoo.class);

	public static void main(String[] args) {

		Object lockA = new Object();
		Object lockB = new Object();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lockA) {
					try {
						TimeUnit.SECONDS.sleep(5);
						synchronized (lockB) {
						}
					} catch (InterruptedException e) {
						logger.error("", e);
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lockB) {
					try {
						TimeUnit.SECONDS.sleep(5);
						synchronized (lockA) {
						}
					} catch (InterruptedException e) {
						logger.error("", e);
					}
				}
			}
		}).start();
	}
}
