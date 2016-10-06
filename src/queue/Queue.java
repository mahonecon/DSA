package queue;

import list.*;

/** Queue class, using LinkedList as backbone.*/
public class Queue<E> implements QueueADT<E> {
	List<E> values = new LinkedList<E>();
	
	public Queue() {} //Default constructor
	
	public void add(E value) {
		values.add(value); //values.add(E value) automatically puts the value at the end of the list.
	}
	
	public E remove() {
		return values.remove(0); //values.remove(int ndx) returns the object removed
	}
	
	public E peek() {
		if(values.isEmpty())
			return null; //Return null if empty
		return values.get(0); //Return first object if not.
	}
	
	public int size() {
		return values.size();
	}
}
