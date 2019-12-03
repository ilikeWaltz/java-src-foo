package foo.junit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @BeforeClass 	database = ...;
// @AfterClass		database.logout();

// @Before			output = new File(...);
// @After			output.delete();

// @Test
// 
public class JunitFoo {

	private static final Logger logger = LoggerFactory.getLogger(JunitFoo.class);

	// public static void no-arg method
	@BeforeClass
	public static void beforeClass() {
		logger.info("before class");
	}

	@AfterClass
	public static void afterClass() {
		logger.info("after class");
	}

	@Before
	public void before() {
		logger.info("before");
	}

	@After
	public void after() {
		logger.info("after");
	}

	@Test
	public void t1() {
		logger.info("t1");
	}

	@Test(timeout = 1000)
	public void t2() {
		logger.info("t2");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			logger.error("", e);
		}
	}

}
