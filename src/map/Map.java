package map;

public interface Map<K, V> {
	
	/** @return true if this map has the given key */
	boolean containsKey(K key);
	
	/** @return the value for the given key, or null if the key is not in the map */ 
	V get(K key);
	
	/** Put an entry into this Map with the given key and value
	 * @return old value, or null if not in the Map */
	V put(K key, V value);
	
	/** Remove the entry with the given key, if possible.
	 * @return the value of that entry or null if not in the Map. */
	V remove(K key);

}
