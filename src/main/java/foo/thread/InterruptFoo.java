package foo.thread;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Thread.interrupted() // clear interrupted status
// Thread.currentThread().isInterrupted() // status is unaffected 

// XXX
// thread.interrupt();
// If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods of the Object class, 
// or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int), 
// methods of this class, then its interrupt status will be cleared and it will receive an InterruptedException. 

public class InterruptFoo {

	private static Logger logger = LoggerFactory.getLogger(InterruptFoo.class);

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				// while (!Thread.interrupted()) {
				while (!Thread.currentThread().isInterrupted()) {
					logger.info("Thread.currentThread().isInterrupted(): {}", Thread.currentThread().isInterrupted());
				}
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();

		logger.info("thread.isInterrupted(): {}", thread.isInterrupted());
		TimeUnit.MICROSECONDS.sleep(300);

		thread.interrupt();
		logger.info("thread.isInterrupted(): {}", thread.isInterrupted());
	}
}
