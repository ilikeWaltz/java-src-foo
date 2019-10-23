package foo.util.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// -------- java.util.concurrent.ConcurrentHashMap
//
// ---------------------- ConcurrentHashMap.Node<K, V>
// int hash
// K key
// V val
// Node<K,V> next

// ---------------------- Node<K,V>[] table
// ---------------------- Node<K,V>[] nextTable

// what is spread?

public class ConcurrentHashMapFoo {

	public static void main(String[] args) {

		Map<String, String> map = new ConcurrentHashMap<>();

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
