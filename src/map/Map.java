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

	/** @return true if size() == 0 */
	boolean isEmpty();
	
	/** @return the size of the map */
	int size();
	
	/** remove all values and keys from the Map */
	void clear();
	
	/** @return true only if there are at least two entries in this map with the same value */
	boolean hasDuplicateValues();
}
