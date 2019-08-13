package foo.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.util.concurrent.Callable<V>

// V call() throws Exception;

public class CallableFoo {

	private static Logger logger = LoggerFactory.getLogger(CallableFoo.class);

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(new Callabler(System.currentTimeMillis()));
		executorService.shutdown();

		Integer integer = future.get();
		logger.info("{}", integer);

	}

	private static class Callabler implements Callable<Integer> {

		private long timeout;

		public Callabler(long timeout) {
			this.timeout = timeout;
		}

		@Override
		public Integer call() throws Exception {

			TimeUnit.SECONDS.sleep(timeout % 3);

			if (timeout % 2 == 0)
				return 1;
			else
				return 0;

		}

	}
}
