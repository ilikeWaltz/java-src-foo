package foo.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.util.concurrent.CompletionService<V>

// Future<V> submit(Callable<V> task);				//
// Future<V> submit(Runnable task, V result);		//

// Future<V> take() throws InterruptedException;	// Retrieves and removes the Future representing the next completed task, waiting if none are yet present.

// Future<V> poll();								// Retrieves and removes the Future representing the next completed task, or null if none are present.

// Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException;
public class CompletionServiceFoo {

	private static Logger logger = LoggerFactory.getLogger(CompletionServiceFoo.class);

	public static void main(String[] args) {

		// executor
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		//
		FooCaller f1 = new FooCaller(3);
		FooCaller f2 = new FooCaller(6);
		FooCaller f3 = new FooCaller(9);

		//
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

		completionService.submit(f1);
		completionService.submit(f2);
		completionService.submit(f3);

		// TODO i
		for (int i = 0; i < 3; i++) {
			// block waiting
			Future<Integer> take;
			try {
				take = completionService.take();
				logger.info("completionService.take():	{}", take.get());
			} catch (InterruptedException e) {
				logger.error("", e);
			} catch (ExecutionException e) {
				logger.error("", e);
			}
		}

		//
		executorService.shutdown();
	}
}

class FooCaller implements Callable<Integer> {

	private static Logger logger = LoggerFactory.getLogger(FooCaller.class);

	private Integer secs;

	public FooCaller(Integer secs) {
		this.secs = secs;
	}

	@Override
	public Integer call() throws Exception {

		logger.info("Caller Start, work time: {}", secs);
		TimeUnit.SECONDS.sleep(secs);
		logger.info("Caller End, work time:	{}", secs);

		return secs;
	}

}