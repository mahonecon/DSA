package hash;
import list.*;

/**
 * A table which allows for quick access to data. Duplicates are permitted.
 * E should define equals(Object) and hashCode()
 * @author CJ Mahoney
 *
 */
public class HashTable<E> {

	List<List<E>> lists = new ArrayList<List<E>>();
	int keyCount = 0; //size
	
	public HashTable() { //default capacity is 10
		this(10);
	}
	/** @param capacity is size of ArrayList*/
	public HashTable(int capacity) {
		for(int i = 0; i < capacity; i++)
			lists.add(new LinkedList<E>());
	}
	
	/**return a valid index to lists */
	private int getCode(Object obj) {
		int code = obj.hashCode();
		code = Math.abs(code);
		code = code % lists.size();
		return code;
	}
	
	/**@return true if given obj is in this HashTable*/
	public boolean containsKey(Object obj) {
		int code = getCode(obj);
		return lists.get(code).contains(obj);
	}
	
	/** Add the given value to this HashTable*/
	public void put(E value) {
		int code = getCode(value);
		lists.get(code).add(value);
		keyCount++;
	}
	
	/**@return the given value from this HashTable, or null
	 * if not found */
	public E get(E value) {
		int code = getCode(value);
		List<E> list = lists.get(code);
		int ndx = list.indexOf(value);
		if (ndx < 0) 
			return null;
		return list.get(ndx);
	}
	
	/**Remove the given object from this HashTable, if possible
	 * @return true if it was removed */
	public boolean remove(Object obj) {
		int code = getCode(obj);
		if (lists.get(code).remove(obj)) {
			keyCount--;
			return true;
		}
		return false;
	}
	
	public int size() {
		return keyCount;
	}
	
	public boolean isEmpty() {
		if(keyCount != 0) {
			return false;
		}
		return true;
	}
	
	public void clear() {
		lists.clear();
		keyCount = 0;
	}
	
	public Iterator<E> iterator() {
		return new TableIterator<E>(this);
	}
}