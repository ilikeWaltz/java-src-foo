package foo.thread;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Thread.setDaemon(boolean on) 
// 
// This method must be invoked before the thread is started. 
// The Java Virtual Machine exits when the only threads running are all daemon threads. 

// Thread.isDaemon() 

public class DaemonFoo {

	private static Logger logger = LoggerFactory.getLogger(DaemonFoo.class);

	public static void main(String[] args) {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					logger.error("", e);
				}
				logger.info("Thread.currentThread().isDaemon(): {}", Thread.currentThread().isDaemon());
			}
		});

		// true: JVM end immediately
		// false: JVM wait for this thread to end
		thread.setDaemon(false);
		logger.info("thread.isDaemon(): {}", thread.isDaemon());

		thread.start();
	}
}
