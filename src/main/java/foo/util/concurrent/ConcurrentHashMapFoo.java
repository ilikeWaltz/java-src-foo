package foo.util.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// ---------------------- ConcurrentHashMap.Node<K, V>
// int hash
// K key
// V val
// Node<K,V> next

// ---------------------- Node<K,V>[] table
// ---------------------- Node<K,V>[] nextTable


public class ConcurrentHashMapFoo {

	/**
	 * 
	 */
	public void t() {
		Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("", "");
	}
}
