package foo.util;

import java.util.HashMap;
import java.util.Map;

// ---------------------- Node
// int hash
// K k
// V v
// Node<K,V> next

// ---------------------- table
// default capacity?
// default load factor?
// threshold = capacity * loadFactor

// how to put node in table? 
// how to resize?

// 
public class HashMapFoo {

	public static void main(String[] args) {

		Map<String, String> hashMap = new HashMap<>();

		String k;
		String v;
		for (int i = 0; i < 1 << 6; i++) {
			k = "k_" + i;
			v = "v_" + i;
			hashMap.put(k, v);
		}

	}
}
