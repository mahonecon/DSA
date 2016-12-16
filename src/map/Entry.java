package map;

class Entry<K, V> implements Comparable<Entry<K, V>> {
	K key;
	V value;
	
	Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public int compareTo(Entry<K, V> e) {
		return compareTo(e);
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
	
	public String toString() {
		String str = "";
		str += key + " - ";
		str += value;
		return str;
	}
	
	public boolean equals(Entry<K,V> e) {
		if(key.equals(e.key) && value.equals(e.value)) {
			return true;
		}
		return false;
	}
}
