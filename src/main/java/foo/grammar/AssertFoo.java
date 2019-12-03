package foo.grammar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// XXX 
// what is assert?
// when use assert?
// how to use assert?

// 
// vm args:

// -ea	(-enableassertions)
// -da	(-disableassertions)	default

// -ea:package
// -da:package

public class AssertFoo {

	private static final Logger logger = LoggerFactory.getLogger(AssertFoo.class);

	public static void main(String[] args) {

		int i = 9;

		assert i < 0;
		assert i < 0 : "i must lt 0";

	}

}
