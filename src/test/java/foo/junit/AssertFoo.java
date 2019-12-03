package foo.junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

// org.junit.Assert
//
// void assertTrue(String message, boolean condition)
// void assertNull(String message, Object object)

public class AssertFoo {

	List<String> l;

	@Test
	public void assertTrueFoo() {
		boolean c = true;
		Assert.assertTrue("", c);
	}

	@Test
	public void assertNullFoo() {
		// Assert.assertNull(l);
		Assert.assertNull("msg", l);
	}

	@Test
	public void assertNotNullFoo() {
		// Assert.assertNotNull(l);
		Assert.assertNotNull("msg", l);
	}

}
