package hash;
import list.*;

/**
 * A table which allows for quick access to data. Duplicates are permitted.
 * E should define equals(Object) and hashCode()
 * 2.0 adjusts table size for efficiency
 * 
 * @author CJ Mahoney
 * 
 * @version 2.0
 *
 */
public class HashTable<E> {

	List<List<E>> lists = new ArrayList<List<E>>(); //Creates an ArrayList of Lists of type E for the HashTable.
	int keyCount = 0; //size
	static final int MAX = 10; //2.0: MAX constant for determining whether or not to rebuild.
	int maxList = 0; //2.0: Length of the longest Linked List.
	
	public HashTable() { //default capacity is 10
		this(10);
	}
	
	/** @param capacity is size of ArrayList*/
	public HashTable(int capacity) {
		for(int i = 0; i < capacity; i++)
			lists.add(new LinkedList<E>()); //Adds capacity worth of LinkedLists to ArrayList.
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
	
	/** Add the given value to this HashTable
	 * 2.0: Rebuild the table if longest list > MAX */
	public void put(E key) {
		int code = getCode(key);
		List<E> list = lists.get(code);
		list.add(key);
		keyCount++;
		if(list.size() > maxList) { //2.0: If list is the largest list
			maxList = list.size(); //2.0: Set maxList to list.size()
			rehash(); //2.0: rebuild hash table.
		}
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
	
	/** @return the number of keys in the hashtable*/
	public int size() {
		return keyCount;
	}
	
	/** @return true if there are no keys in the hashtable */
	public boolean isEmpty() {
		if(keyCount != 0) {
			return false;
		}
		return true;
	}
	
	/** Clears the hashtable */
	public void clear() {
		lists.clear();
		keyCount = 0;
	}
	
	/** @return an Iterator to iterate through the HashTable */
	public Iterator<E> iterator() {
		return new TableIterator<E>(this);
	}
	
	/** 2.0: Rebuilds the hash table if necessary.  When rebuilt, doubles the amount of Linked Lists
	 * contained in the HashTable, to make each individual Linked List smaller. */
	private void rehash() {
		if(maxList <= MAX) //To rebuild or not to rebuild, that is the question.
			return;
		List<List<E>> table = new ArrayList<List<E>>();
		for(int i = 0; i < lists.size() * 2; i++) { //Create a table populate with twice as many Linked Lists.
			table.add(new LinkedList<E>());
		}
		Iterator<E> itty = iterator();
		while(itty.hasNext()) {
			E value = itty.next();
			int code = Math.abs(value.hashCode());
			code = code % table.size();
			List<E> list = table.get(code);
			list.add(value);
			if(list.size() > maxList)
				maxList = list.size();
		}
		lists = table;
	}
}