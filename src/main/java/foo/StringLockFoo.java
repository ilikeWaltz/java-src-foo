package foo;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringLockFoo {

	private static final Logger logger = LoggerFactory.getLogger(StringLockFoo.class);

	public static void main(String[] args) {

		String l1 = "";
		String l2 = "";

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// XXX lock not work here!
					synchronized (l1 + l2) {
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
