package foo.util.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountDownLatchFoo01 {

	private static Logger logger = LoggerFactory.getLogger(CountDownLatchFoo01.class);

	public static void main(String[] args) throws InterruptedException {
		long timeTasks = timeTasks(3, new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(System.currentTimeMillis() % 5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		logger.info("time cost: {}", timeTasks);
	}

	public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {

		CountDownLatch startGate = new CountDownLatch(1);
		CountDownLatch endGate = new CountDownLatch(nThreads);

		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						startGate.await();

						try {
							task.run();
						} finally {
							endGate.countDown();
						}

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t.start();
		}

		long start = System.currentTimeMillis();
		startGate.countDown(); // 1 -> 0, notify runners start
		endGate.await(); // wait for runners end
		long end = System.currentTimeMillis();

		return end - start;

	}
}
