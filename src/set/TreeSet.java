package set;
import tree.*;

import list.Iterator;

public class TreeSet<E extends Comparable> implements Set<E> {
	
	BinaryTree<E> tree = new EmptyBinarySearchTree();
	int size = 0;

	public boolean add(E value) {
		if(tree.containsKey(value))
			return false;
		tree=tree.add(value);
		size++;
		return true;
	}

	public boolean contains(Object obj) {
		E value;
		try{
			value=(E) obj;
			return tree.containsKey(value);
		}
		catch(ClassCastException cce){
			return false;
		}
	}

	public boolean remove(Object obj) {
		if(!contains(obj))
			return false;
		tree=tree.remove(obj);
		size--;
		return true;
	}

	public Iterator<E> iterator() {
		if(size==0)
			return new EmptyIterator();
		return new TreeSetIterator(this);
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

}
