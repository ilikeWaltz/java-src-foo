package foo.thread;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Thread.isAlive()
// A thread is alive if it has been started and has not yet died.

public class AliveFoo {

	private static Logger logger = LoggerFactory.getLogger(AliveFoo.class);

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread();

		logger.info("{}", thread.isAlive());
		thread.start();
		logger.info("{}", thread.isAlive());

		TimeUnit.SECONDS.sleep(1);
		logger.info("{}", thread.isAlive());

	}
}
