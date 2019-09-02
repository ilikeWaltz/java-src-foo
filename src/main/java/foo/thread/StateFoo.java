package foo.thread;

// ---------------- Thread.State
// new					// Thread state for a thread which has not yet started.
// runnable				// A thread is executing in the Java virtual machine but it may be waiting for other resources from the operating system such as processor.
// blocked				// A thread is waiting for a monitor lock to enter a synchronized block/method or reenter a synchronized block/method after calling Object.wait.
// waiting				// [1]
// timed_waiting		// [2]
// terminated			// The thread has completed execution.

// [1]
// A thread is in the waiting state due to calling one of the following methods: 
// Object.wait with no timeout 
// Thread.join with no timeout 
// LockSupport.park 
// 
// A thread in the waiting state is waiting for another thread to perform a particular action.
// For example, 
// a thread that has called Object.wait() on an object is waiting for another thread to call Object.notify() or Object.notifyAll() on that object. 
// A thread that has called Thread.join() is waiting for a specified thread to terminate.

// [2]
// A thread is in the timed waiting state due to calling one of the following methods with a specified positive waiting time: 
// Thread.sleep 
// Object.wait with timeout 
// Thread.join with timeout 
// LockSupport.parkNanos 
// LockSupport.parkUntil 

public class StateFoo {
	
}
