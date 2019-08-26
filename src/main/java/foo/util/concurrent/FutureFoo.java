package foo.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// A Future represents the result of an asynchronous computation.
// java.util.concurrent.Future<V>

// boolean cancel(boolean mayInterruptIfRunning);
// boolean isCancelled();

// boolean isDone();

// V get() throws InterruptedException, ExecutionException;
// V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;

public class FutureFoo {

	private static Logger logger = LoggerFactory.getLogger(FutureFoo.class);

	private ExecutorService executorService = Executors.newSingleThreadExecutor();

	@Test
	public void callableFuture() throws InterruptedException, ExecutionException {

		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "c";
			}
		};

		Future<String> future = executorService.submit(callable);
		logger.info("future.isDone(): {}", future.isDone());
		logger.info("future.isCancelled(): {}", future.isCancelled());
		logger.info("future.get(): {}", future.get());
		logger.info("future.isDone(): {}", future.isDone());

		executorService.shutdown();
	}

	@Test
	public void runnableFuture() throws InterruptedException, ExecutionException {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
			}
		};

		//
		// Future<String> future = (Future<String>)
		// executorService.submit(runnable);
		//
		Future<String> future = executorService.submit(runnable, "123");

		logger.info("future.isDone(): {}", future.isDone());
		logger.info("future.isCancelled(): {}", future.isCancelled());
		logger.info("future.get(): {}", future.get());
		logger.info("future.isDone(): {}", future.isDone());

		executorService.shutdown();
	}

}
