package foo.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.util.concurrent.Callable<V>
//
// A task that returns a result and may throw an exception. 
// Implementors define a single method with no arguments called call. 

// V call() throws Exception; // Computes a result, or throws an exception if unable to do so.

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
