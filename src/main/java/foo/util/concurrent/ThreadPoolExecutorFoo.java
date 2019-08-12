package foo.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// ------------------------------- ThreadPoolExecutor

// int corePoolSize
// int maximumPoolSize

// BlockingQueue<Runnable> workQueue

// HashSet<Worker> workers

// ThreadFactory threadFactory

public class ThreadPoolExecutorFoo {

	private static Logger logger = LoggerFactory.getLogger(ThreadPoolExecutorFoo.class);

	public static void main(String[] args) {

		int nThreads = 3;

		//
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		//
	}
}
