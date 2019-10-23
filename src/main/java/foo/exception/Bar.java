package foo.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bar {

	private static final Logger logger = LoggerFactory.getLogger(Bar.class);

	public static void main(String[] args) {
		try {
			throw new FileNotFoundException();
		} catch (IOException e) {
			logger.error("", e);

			// XXX ex here can't be caught!
			throw new RuntimeException();

		} catch (Exception e) {
			logger.error("", e);
		}
	}
}
