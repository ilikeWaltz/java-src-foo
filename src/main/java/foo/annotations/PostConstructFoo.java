package foo.annotations;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostConstructFoo {

	private static final Logger logger = LoggerFactory.getLogger(PostConstructFoo.class);

	public PostConstructFoo() {
		logger.info("Construct");
	}

	@PostConstruct
	public void foo() {
		logger.info("@PostConstruct");
	}

	public static void main(String[] args) {

		// not work
		new PostConstructFoo();

		// should be used in DI frameworks

	}
}
