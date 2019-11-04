package foo.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.util.concurrent.ThreadPoolExecutor	(I) 
//
// An ExecutorService that executes each submitted task using one of possibly several pooled threads, 
// normally configured using Executors factory methods. 
//
//
// --------------- boolean allowCoreThreadTimeOut
// If false (default), core threads stay alive even when idle. 
// If true, core threads use keepAliveTime to time out waiting for work.
//
// --------------- int corePoolSize	
// the number of threads to keep in the pool, even if they are idle, unless allowCoreThreadTimeOut is set
// Core pool size is the minimum number of workers to keep alive (and not allow to time out etc) unless allowCoreThreadTimeOut is set, in which case the minimum is zero.
//
// --------------- int maximumPoolSize
//
// BlockingQueue<Runnable> workQueue
//
// HashSet<Worker> workers
//
// ThreadFactory threadFactory

public class ThreadPoolExecutorFoo {

	private static Logger logger = LoggerFactory.getLogger(ThreadPoolExecutorFoo.class);

	public static void fo() {

		int nThreads = 3;

		// same way
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
	}

	public static void foo() throws InterruptedException {

		int nThreads = 3;
		int maximumPoolSize = 5;

		// when the number of threads is greater than the core,
		// this is the maximum time
		// that excess idle threads will wait for new tasks before terminating.
		long keepAliveTime = 3;

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(nThreads, maximumPoolSize, keepAliveTime,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		threadPool.allowCoreThreadTimeOut(true);

		TimeUnit.SECONDS.sleep(5);
		boolean allowsCoreThreadTimeOut = threadPool.allowsCoreThreadTimeOut();
		int corePoolSize = threadPool.getCorePoolSize();

		logger.info("allowsCoreThreadTimeOut: {}", allowsCoreThreadTimeOut);
		logger.info("corePoolSize: {}", corePoolSize);

		threadPool.shutdown();
	}

	// XXX reject when nTasks > maximumPoolSize + BlockingQueue size
	public static void fooo() {

		int nThreads = 3;
		int maximumPoolSize = 5;
		int nQueueCapacity = 3;

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(nThreads, maximumPoolSize, 0L, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(nQueueCapacity), new RejectedExecutionHandler() {
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						logger.info("rejected, Runnable: {}, ThreadPoolExecutor: {}", r, executor);
					}
				});

		for (int i = 0; i < 10; i++) {
			final int idx = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						logger.info("{}, {}", idx, Thread.currentThread());
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						logger.error("", e);
					}
				}
			});
		}
		threadPool.shutdown();
	}

	public static void main(String[] args) throws Exception {
		foo();
//		fooo();
	}
}
