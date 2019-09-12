package foo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// -Dsun.net.client.defaultConnectTimeout=10000 -Dsun.net.client.defaultReadTimeout=10000
public class ThreadPoolFoo {

	private static final Logger logger = LoggerFactory.getLogger(ThreadPoolFoo.class);

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				logger.info("{} start!", Thread.currentThread());
				try {
					HttpUtil.getKv("http://localhost:8080/req", null, null);
				} catch (Exception e) {
					logger.error("", e);
				}
				logger.info("{} done!", Thread.currentThread());
			}
		};

		ThreadPoolExecutor tpe = (ThreadPoolExecutor) threadPool;

		for (;;) {

			threadPool.execute(runnable);

			try {
				TimeUnit.SECONDS.sleep(60);
			} catch (InterruptedException e) {
				logger.error("", e);
			}

			int size = tpe.getQueue().size();
			// logger.info("tpe.getQueue().size(): {}", size);

			int activeCount = tpe.getActiveCount();
			// logger.info("tpe.getActiveCount(): {}", activeCount);

			long completedTaskCount = tpe.getCompletedTaskCount();
			// logger.info("tpe.getCompletedTaskCount(): {}",
			// completedTaskCount);

			long taskCount = tpe.getTaskCount();
			// logger.info("tpe.getTaskCount(): {}", taskCount);

			logger.info("queue size:{},\tactiveCount:{},\tcompletedTaskCount:{},\ttaskCount:{}", size, activeCount,
					completedTaskCount, taskCount);
		}

	}
}
