package foo.util;

import java.util.HashMap;
import java.util.Map;

// ---------------------- java.util.HashMap.Node<K, V>
// int hash TODO 
// K k
// V v
// Node<K,V> next

// ---------------------- Node<K,V>[] table
// default capacity?
// default load factor?
// threshold = capacity * loadFactor

// how HashMap put new Node in table?
// how HashMap handle concurrent put? TODO

// how table resize?
// how threshold resize?

// 
public class HashMapFoo {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		String k, v;
		for (int i = 0, j = 1 << 6; i < j; i++) {
			k = "k_" + i;
			v = "v_" + i;
			map.put(k, v);
		}
	}

}
