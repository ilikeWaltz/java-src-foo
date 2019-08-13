package foo.util.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.Unsafe;

// CAS
// Compare and Swap (Optimistic lock)

// sun.misc.Unsafe

//	c
//	int cas(long *addr, long old, long new)
//	{
//		if(*addr != old)
//			return 0;
//		*addr = new;
//		return 1;
//	}

public class CAS {

	private static Logger logger = LoggerFactory.getLogger(CAS.class);

	public static void main(String[] args) {

		Unsafe unsafe = sun.misc.Unsafe.getUnsafe();

		logger.info("{}", unsafe);
	}
}
