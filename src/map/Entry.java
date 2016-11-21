package map;

class Entry<K, V> implements Comparable<Entry<K, V>> {
	K key;
	V value;
	
	Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public int compareTo(Entry<K, V> e) {
		return 1;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if(!(obj instanceof Entry)) {
			return false;
		}
		Entry other = (Entry) obj;
		return key.equals(other.key);
	}
	
	public int hashCode() {
		return key.hashCode();
	}
}
