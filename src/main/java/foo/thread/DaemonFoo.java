package foo.thread;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This method must be invoked before the thread is started. 
// The Java Virtual Machine exits when the only threads running are all daemon threads. 
// 
// Thread.setDaemon(boolean on) 

// Thread.isDaemon() 

public class DaemonFoo {

	private static Logger logger = LoggerFactory.getLogger(DaemonFoo.class);

	public static void main(String[] args) {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					logger.error("", e);
				}
				logger.info("Thread.currentThread().isDaemon(): {}", Thread.currentThread().isDaemon());
			}
		});

		// true: JVM end immediately
		// false: JVM wait for user thread to end
		thread.setDaemon(true);

		thread.start();
	}
}
