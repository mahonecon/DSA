package set;

import tree.*;
import list.Iterator;

@SuppressWarnings("rawtypes")
public class TreeSet<E extends Comparable> implements Set<E> {
	
	BinaryTree<E> tree = new EmptyBinarySearchTree<E>();
	int size = 0;

	public boolean add(E value) {
		if(tree.containsKey(value))
			return false;
		tree = tree.add(value);
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean contains(Object obj) {
		E value;
		try{
			value = (E)obj;
			return tree.containsKey(value);
		}
		catch(ClassCastException cce){
			return false;
		}
	}

	public boolean remove(Object obj) {
		if(!contains(obj))
			return false;
		tree = tree.remove(obj);
		size--;
		return true;
	}

	@SuppressWarnings("unchecked")
	public Iterator<E> iterator() {
		if(size == 0)
			return new EmptyIterator<E>();
		return new TreeSetIterator<E>(this);
	}
	
	public int size() {
		return tree.size();
	}
	
	public String toString() {
		Iterator<E> itty = iterator();
		String str = "";
		while(itty.hasNext()) {
			str += itty.next() + " ";
		}
		return str;
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
		Set<E> intersect = new TreeSet<E>();
		if(other instanceof TreeSet<?>) {
			Iterator<E> itt = other.iterator();
			while(itt.hasNext()) {
				if(itt != null) {
					Object obj = itt.next();
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
		Set<E> difference = new TreeSet<E>();
		if(other instanceof TreeSet<?>) {
			Iterator<E> it = iterator();
			while(it.hasNext()) {
				if(it != null) {
					Object obj = it.next();
					if(obj != null && !other.contains(obj)) {
						difference.add((E)obj);
					}
				}
			}
		}
		return difference;
	}
}
