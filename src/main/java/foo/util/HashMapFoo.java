package foo.util;

import java.util.HashMap;
import java.util.Map;

// ---------------------- HashMap.Node<K, V>
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

		String k;
		String v;
		for (int i = 0; i < 1 << 6; i++) {
			k = "k_" + i;
			v = "v_" + i;
			map.put(k, v);
		}

		System.out.println(map);
	}

}
