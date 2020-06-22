package foo;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringLockFoo2 {

	private static final Logger logger = LoggerFactory.getLogger(StringLockFoo2.class);

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// XXX String.intern()
					synchronized (new String("").intern()) {
						try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							logger.error("", e);
						}
						logger.info("done!");
					}
				}
			}).start();
		}
	}
}
