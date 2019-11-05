package foo.util.concurrent.countDownLatch;

// java.util.concurrent.CountDownLatch
// latch: a metal bar with a catch and lever used for fastening a door or gate.

// public CountDownLatch(int count) 				// Constructs a CountDownLatch initialized with the given count.

// void await() 									// Causes the current thread to wait until the latch has counted down to zero, unless the thread is interrupted. 
// boolean await(long timeout, TimeUnit unit) 		// Causes the current thread to wait until the latch has counted down to zero, unless the thread is interrupted, or the specified waiting time elapses. 

// void countDown() 								// Decrements the count of the latch, releasing all waiting threads if the count reaches zero. 

// long getCount() 									// Returns the current count. This method is typically used for debugging and testing purposes.

public class CountDownLatchFoo {

}
