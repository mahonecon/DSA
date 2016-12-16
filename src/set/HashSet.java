package set;

import hash.*;
import list.Iterator;
import tree.EmptyIterator;

public class HashSet<E> implements Set<E> {

	HashTable<E> table = new HashTable<E>();
	
	public boolean add(E value){
		if(contains(value))
			return false;
		table.put(value);
		return true;
	}
	
	public boolean contains(Object obj){
		return table.containsKey(obj);
	}
	
	public boolean remove(Object obj){
		return table.remove(obj);
	}
	
	public int size() {
		return table.size();
	}
	
	public Iterator<E> iterator(){
		if(size() == 0) {
			return new EmptyIterator();
		}
		return table.iterator();
	}
	
	public String toString() {
		Iterator<E> itty = iterator();
		String str = "[";
		while(itty.hasNext()) {
			str += itty.next();
			if(itty.hasNext()) {
				str += ", ";
			}
		}
		return str += "]";
	}
	
	/** @return true if obj is a Set and all the values in this Set are in the other Set, 
    and all the values in the other Set are in this Set */ 
	public boolean equals(Object obj) {
		if(obj instanceof Set<?>) {
			Set<?> h = (Set<?>) obj;
			if(h.size() != size()) {
				return false;
			}
			Iterator<?> itty = iterator();
			while(itty.hasNext()) {
				if(!(h.contains(itty.next()))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public Set<E> intersection(Set<E> other) {
		Set<E> intersect = new HashSet<E>();
		if(other instanceof HashSet<?>) {
			Iterator<E> itt = other.iterator();
			while(itt.hasNext()) {
				E temp = itt.next();
				if(temp != null) {
					Object obj = temp;
					if(obj != null && this.contains(obj)) {
						intersect.add((E)obj);
					}
				}
			}
		}
		return intersect;
	}
	
	@SuppressWarnings("unchecked")
	public Set<E> difference(Set<E> other) {
		Set<E> difference = new HashSet<E>();
		if(other instanceof HashSet<?>) {
			Iterator<E> itt = iterator();
			while(itt.hasNext()) {
				E temp = itt.next();
				if(temp != null) {
					Object obj = temp;
					if(obj != null && !other.contains(obj)) {
						difference.add((E) obj);
					}
				}
			}
		}
		return difference;
	}
}