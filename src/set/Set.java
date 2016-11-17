package set;

import list.Iterator;

public interface Set<E> {
	
	boolean add(E value);
	
	boolean contains(Object obj);

	boolean remove(Object obj);
	
	public int size();
	
	Iterator<E> iterator();
	
	/** @return the elements of this Set as a String */
	public String toString();
	
	/** @return true if obj is a Set and all the values in this Set are in the other Set, 
    and all the values in the other Set are in this Set */
	public boolean equals(Object obj);
}
