package foo.param;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringParamFoo {

	private static final Logger logger = LoggerFactory.getLogger(StringParamFoo.class);

	public static void main(String[] args) {

		String str = null;
		logger.info("{}", str);

		assignValue(str);
		logger.info("{}", str);
	}

	private static void assignValue(String s) {
		s = new Date().toString();
	}
}
