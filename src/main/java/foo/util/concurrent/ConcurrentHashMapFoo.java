package foo.util.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 1. 存储原理
public class ConcurrentHashMapFoo {

	private static Logger logger = LoggerFactory.getLogger(ConcurrentHashMapFoo.class);

	/**
	 * 
	 */
	public void t() {
		Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("", "");
	}
}
