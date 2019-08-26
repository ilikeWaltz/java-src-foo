package foo.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// A task that returns a result and may throw an exception.
// java.util.concurrent.Callable<V>

// V call() throws Exception;

public class CallableFoo {

	private static Logger logger = LoggerFactory.getLogger(CallableFoo.class);

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		new Callable<String>() {
			@Override
			public String call() throws Exception {
				return null;
			}
		};
	}

}
