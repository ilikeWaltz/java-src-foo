package foo.util.concurrent.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CyclicBarrierFoo2 {

	private static Logger logger = LoggerFactory.getLogger(CyclicBarrierFoo2.class);

	public static void main(String[] args) throws InterruptedException {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

		// 如果是一个初始的CyclicBarrier，则reset()之后，什么也不会发生
		// cyclicBarrier.reset();

		Thread.sleep(100);

		//
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					logger.info("CyclicBarrier.await()");
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					logger.info("CyclicBarrier Interrupted");
				} catch (BrokenBarrierException e) {
					logger.info("BrokenBarrierException");
				}
				logger.info("end");
			}
		};

		// 如果是一个已经打开一次的CyclicBarrier，则reset()之后，什么也不会发生
		for (int i = 0; i < 5; i++) {
			threadPool.submit(runnable);
			Thread.sleep(100);
		}
		cyclicBarrier.reset();

		Thread.sleep(500);

		// TODO
		// If any parties are currently waiting at the barrier,
		// they will return with a BrokenBarrierException.
		threadPool.submit(runnable);
		Thread.sleep(100);

		cyclicBarrier.reset();

		Thread.sleep(500);

		for (int i = 0; i < 2; i++)
			threadPool.submit(runnable);

		Thread.sleep(100);
		cyclicBarrier.reset();

		//
		threadPool.shutdown();

	}
}
