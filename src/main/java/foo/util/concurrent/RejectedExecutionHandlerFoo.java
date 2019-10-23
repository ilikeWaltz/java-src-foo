package foo.util.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.util.concurrent.RejectedExecutionHandler	(I)
// A handler for tasks that cannot be executed by a ThreadPoolExecutor.
//
// void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
// 
// ------ java.util.concurrent.ThreadPoolExecutor.AbortPolicy
// ------ java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy
// ------ java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy
// ------ java.util.concurrent.ThreadPoolExecutor.DiscardPolicy

public class RejectedExecutionHandlerFoo {

	private static final Logger logger = LoggerFactory.getLogger(RejectedExecutionHandlerFoo.class);

}
