package map;

import hash.*;
import list.Iterator;

/** An implementation of Map, using a HashTable */
public class HashMap<K, V> implements Map<K,V> {
	HashTable<Entry<K,V>> table = new HashTable<Entry<K,V>>();
	
	public HashMap(int capacity) {
		table = new HashTable<Entry<K,V>>(capacity);
	}
	
	public HashMap() {
		this(10);
	}
	
	public boolean containsKey(K key) {
		Entry<K, V> entry = new Entry<K,V>(key, null);
		return table.containsKey(entry);
	}
	
	public V get(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = table.get(entry);
		if(entry == null) {
			return null;
		}
		return entry.value;
	}

	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V>(key,value);
		Entry<K,V> oldEntry = table.get(newEntry);
		if(oldEntry == null) {
			table.put(newEntry);
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
	}
	
	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = table.get(entry);
		if(entry == null) return null;
		table.remove(entry);
		return entry.value;
	}
	
	public boolean isEmpty() {
		return table.isEmpty();
	}
	
	public int size() {
		return table.size();
	}
	
	public String toString() {
		String str = "[";
		Iterator<Entry<K,V>> itty = table.iterator();
		while(itty.hasNext()) {
			Entry e = (Entry)itty.next();
			str += e.toString();
			if(itty.hasNext()) {
				str += ",";
				}
			}
		str += "]";
		return str;
	}
	
	public void clear() {
		table = new HashTable<Entry<K,V>>(10);
	}
}