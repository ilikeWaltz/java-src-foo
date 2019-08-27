package foo.thread;

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

		Thread thread = new Thread();

		thread.setDaemon(true);
		thread.start();
	}
}
