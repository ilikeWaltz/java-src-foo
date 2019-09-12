package foo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 
public class SleepFoo {

	private static final Logger logger = LoggerFactory.getLogger(SleepFoo.class);

	public static void main(String[] args) {
		try {
			Thread.sleep(1000 * 60 * 10);
		} catch (InterruptedException e) {
			logger.error("", e);
		}
	}

}
