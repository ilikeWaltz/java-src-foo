package foo.util.concurrent.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CyclicBarrierFoo1 {

	private static Logger logger = LoggerFactory.getLogger(CyclicBarrierFoo1.class);

	public static void main(String[] args) throws InterruptedException {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

		// Returns the number of parties required to trip this barrier.
		logger.info("getParties(): {}", cyclicBarrier.getParties());

		// Returns the number of parties currently waiting at the barrier.
		// This method is primarily useful for debugging and assertions.
		logger.info("getNumberWaiting(): {}", cyclicBarrier.getNumberWaiting());

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					logger.info("CyclicBarrier.await()");
					cyclicBarrier.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("end");
			}
		};

		// 添加一个等待线程
		new Thread(runnable).start();

		Thread.sleep(100);
		logger.info("getNumberWaiting(): {}", cyclicBarrier.getNumberWaiting());

		Thread.sleep(100);

		new Thread(runnable).start();

		Thread.sleep(100);
		logger.info("getNumberWaiting(): {}", cyclicBarrier.getNumberWaiting());

		Thread.sleep(100);

		// 可循环复用
		new Thread(runnable).start();

		Thread.sleep(100);
		logger.info("getNumberWaiting(): {}", cyclicBarrier.getNumberWaiting());

		Thread.sleep(100);

		new Thread(runnable).start();

		Thread.sleep(100);
		logger.info("getNumberWaiting(): {}", cyclicBarrier.getNumberWaiting());

	}
}
