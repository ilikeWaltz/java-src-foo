package foo.thread;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Thread.join() : Waits for this thread to die.

// join() == join(0)
public class JoinFoo {

	private static Logger logger = LoggerFactory.getLogger(JoinFoo.class);

	private static class JoinRunner implements Runnable {

		int sleepTime;

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
		jr1.sleepTime = 4;

		JoinRunner jr2 = new JoinRunner();
		jr2.sleepTime = 3;

		Thread t1 = new Thread(jr1);
		Thread t2 = new Thread(jr2);

		t1.start();
		t2.start();

		t1.join();
		t2.join(); // main thread waits for this thread to die.

		logger.info("main thread end.");
	}
}
