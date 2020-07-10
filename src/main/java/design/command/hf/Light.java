package design.command.hf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Light {

	private static final Logger logger = LoggerFactory.getLogger(Light.class);

	public void on() {
		logger.info("on");
	}

	public void off() {
		logger.info("off");
	}
}
