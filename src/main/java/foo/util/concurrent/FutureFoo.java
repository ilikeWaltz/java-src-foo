package foo.util.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.util.concurrent.Future<V>

// boolean cancel(boolean mayInterruptIfRunning);

// boolean isCancelled();

// boolean isDone();

// V get() throws InterruptedException, ExecutionException;

// V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;

public class FutureFoo {

	private static Logger logger = LoggerFactory.getLogger(FutureFoo.class);

}
