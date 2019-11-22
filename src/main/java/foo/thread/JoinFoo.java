package foo.thread;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// void join() 				// Waits for this thread to die.
// void join(long millis) 	// Waits at most millis milliseconds for this thread to die.

// join() == join(0)		// A timeout of 0 means to wait forever.

public class JoinFoo {

	private static final Logger logger = LoggerFactory.getLogger(JoinFoo.class);

	private static class JoinRunner implements Runnable {

		private int sleepTime;

		@Override
		public void run() {
			logger.info("thread start: {}, time to sleep:{}", Thread.currentThread(), sleepTime);
			try {
				TimeUnit.SECONDS.sleep(sleepTime);
			} catch (InterruptedException e) {
				logger.error("", e);
			}
			logger.info("thread end: {}", Thread.currentThread());
		}
	}

	public static void main(String[] args) throws InterruptedException {

		JoinRunner jr1 = new JoinRunner();
		jr1.sleepTime = 3;

		JoinRunner jr2 = new JoinRunner();
		jr2.sleepTime = 2;

		Thread t1 = new Thread(jr1);
		t1.start();
		t1.join(); // main thread waits for this thread to die.
		logger.info("t1 join() end");

		Thread t2 = new Thread(jr2);
		t2.start();
		t2.join(1500); // main thread waits at most millis milliseconds
		logger.info("t2 join() end");

		logger.info("main thread end.");
	}
}
