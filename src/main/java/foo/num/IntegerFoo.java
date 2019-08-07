package foo.num;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegerFoo {

	private static Logger logger = LoggerFactory.getLogger(IntegerFoo.class);

	@Test
	public void toHexString() {
		logger.info("{}", Integer.toHexString(1024 * 1024));
	}

	@Test
	public void bit() {
		logger.info("1 << 1: {}", 1 << 1);
		logger.info("1 << 2: {}", 1 << 2);
		logger.info("2 << 1: {}", 2 << 1);
		logger.info("2 << 2: {}", 2 << 2);
		logger.info("2 << 3: {}", 2 << 3);
	}
}
