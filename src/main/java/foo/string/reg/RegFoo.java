package foo.string.reg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// ^: start with
// $: end with

// ^$: empty line

// .: any char

// []: range
// [0-9]
// \d

// [a-z]
// [0-9a-zA-Z]

// *: >=0
// +: >=1
// {n}: ==n
// {m, n}

public class RegFoo {

	private static Logger logger = LoggerFactory.getLogger(RegFoo.class);

	public static void main(String[] args) {

		logger.info("{}", "0".matches("^[0-9]$"));
		logger.info("{}", "00".matches("^[0-9]$"));

		logger.info("{}", "0".matches("[0-9]"));
		logger.info("{}", "00".matches("[0-9]"));

		logger.info("{}", "0".matches("\\d"));
		logger.info("{}", "00".matches("\\d"));

		logger.info("{}", "00".matches("[0-9]{2}"));
		logger.info("{}", "000".matches("[0-9]{2}"));

		logger.info("{}", "00".matches("\\d{2}"));
		logger.info("{}", "000".matches("\\d{2}"));
	}
}
