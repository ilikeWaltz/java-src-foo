package foo.num;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitCalFoo {

	private static Logger logger = LoggerFactory.getLogger(BitCalFoo.class);

	@Test
	public void t1() {
		logger.info("{}", 13 & 2);
		logger.info("{}", 15 & 25);
	}
}
