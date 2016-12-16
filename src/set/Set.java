package set;

import list.Iterator;

public interface Set<E> {
	
	boolean add(E value);
	
	boolean contains(Object obj);

	boolean remove(Object obj);
	
	int size();
	
	Iterator<E> iterator();
	
	/** @return the elements of this Set as a String */
	String toString();
	
	/** @return true if obj is a Set and all the values in this Set are in the other Set, 
    and all the values in the other Set are in this Set */
	boolean equals(Object obj);
	
	/** @return a Set which is an intersection of this Set with other. */
	Set<E> intersection(Set<E> other);
	
	/** @return the set of all elements which are in this Set, but not also in the other Set */
	Set <E> difference (Set <E> other);
}
