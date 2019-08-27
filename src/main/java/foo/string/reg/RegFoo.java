package foo.string.reg;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// ^: start with
// $: end with
//
// ^$: empty line

// .: any char

// []: range
// 
// [0-9]
// \d
//
// [a-z]
// [0-9a-zA-Z]
//
// [abc]: a or b or c

// *: >=0
// +: >=1
// {m}: ==m
// {m,n}

public class RegFoo {

	private static Logger logger = LoggerFactory.getLogger(RegFoo.class);

	@Test
	public void test0() {
		logger.info("{}", "");
	}

	// [0-9] == \d
	// ^ and $
	@Test
	public void test01() {

		logger.info("{}", "0".matches("[0-9]")); // true
		logger.info("{}", "0".matches("\\d")); // true

		logger.info("{}", "0".matches("^[0-9]$")); // true
		logger.info("{}", "0".matches("^\\d$")); // true
	}

	@Test
	public void test02() {

		logger.info("{}", "0".matches("[0-9]")); // true
		logger.info("{}", "00".matches("[0-9]")); // false

		logger.info("{}", "0".matches("\\d")); // true
		logger.info("{}", "00".matches("\\d")); // false
	}

	// *
	@Test
	public void test03() {

		logger.info("{}", "".matches("[0-9]*")); // true
		logger.info("{}", "0".matches("[0-9]*")); // true
		logger.info("{}", "00".matches("[0-9]*")); // true

		logger.info("{}", "a".matches("[0-9]*")); // false
	}

	// +
	@Test
	public void test04() {

		logger.info("{}", "".matches("[0-9]+")); // false
		logger.info("{}", "0".matches("[0-9]+")); // true
		logger.info("{}", "00".matches("[0-9]+")); // true

		logger.info("{}", "a".matches("[0-9]+")); // false
	}

	// {n}
	@Test
	public void test05() {

		logger.info("{}", "0".matches("[0-9]{1}")); // true
		logger.info("{}", "00".matches("[0-9]{1}")); // false
	}

	// [^]
	@Test
	public void test06() {
		logger.info("{}", "0".matches("[^0-9]")); // false
		logger.info("{}", "a".matches("[^0-9]")); // true

		logger.info("{}", "0".matches("[^a-zA-Z]")); // true
		logger.info("{}", "a".matches("[^a-zA-Z]")); // false
		logger.info("{}", "A".matches("[^a-zA-Z]")); // false

		logger.info("{}", "0".matches("[^0-9a-zA-Z]")); // false
		logger.info("{}", "_".matches("[^0-9a-zA-Z]")); // true
	}

	// {m, n}
	@Test
	public void test0113() {

		logger.info("{}", "00".matches("[0-9]{2,3}")); // true
		logger.info("{}", "0000".matches("[0-9]{2,3}")); // false

		logger.info("{}", "00".matches("\\d")); // false
		logger.info("{}", "00".matches("\\d*")); // true
		logger.info("{}", "00".matches("\\d{2}")); // true
	}

}
