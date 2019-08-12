package foo.util.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.util
// ------------------------------- interface Queue<E> extends Collection<E>

// boolean add(E e); // throwing an IllegalStateException if no space is currently available.
// boolean offer(E e); //

// E remove(); // throws an exception if this queue is empty.
// E poll(); // returns null if this queue is empty.

// Retrieves, but does not remove, the head of this queue.
// E element(); // throws an exception if this queue is empty.
// E peek(); // returns null if this queue is empty.

public class QueueFoo {

	private static Logger logger = LoggerFactory.getLogger(QueueFoo.class);

	public static void main(String[] args) {

	}
}
