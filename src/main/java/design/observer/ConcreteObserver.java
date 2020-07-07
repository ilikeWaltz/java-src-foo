package design.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteObserver implements Observer {

	private static final Logger logger = LoggerFactory.getLogger(ConcreteObserver.class);

	@Override
	public void update(String msg) {
		logger.info("msg: {}", msg);
		// ...
	}

}