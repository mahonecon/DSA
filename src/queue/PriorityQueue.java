package queue;

import list.*;

public class PriorityQueue<E extends Comparable<E>> implements QueueADT<E> {
	
	List<E> list = new ArrayList<E>();

	public PriorityQueue() {
		
	}

	public void add(E value) {
		list.add(value);
		int added = size() - 1;
		int parent = (added - 1) / 2;
		while(added > 0 && greater(added,parent)){
			swap(added,parent);
			added = parent;
			parent = (added - 1) / 2;
		}
	}

	private void swap(int added, int parent) {
		E add = list.get(added);
		E par = list.get(parent);
		list.set(added, par);
		list.set(parent, add);
	}

	public E remove() {
		int last = size() - 1;
		E result = list.get(0);
		int avali = 0;
		int bc = biggerChild(0);
		while(2 * avali + 1 < last && greater(bc, last)){
			list.set(avali, list.get(last));
			avali = bc;
			bc = biggerChild(avali);
		}
		list.remove(last);
		return result;
	}
	
	public int biggerChild(int parent){
		int left = 2 * parent + 1;
		int right = left + 1;
		if(right >= list.size())
			return left;
		if(greater(right, left))
			return right;
		return left;
	}
	
	private boolean greater(int x, int y){
		return list.get(x).compareTo(list.get(y))>0;
	}

	public E peek() {
		return list.get(0);
	}

	public int size() {
		return list.size();
	}
	
	public void clear(){
		list.clear();
	}

	public boolean isEmpty() {
		return size()==0;
	}
	
	public String toString() {
		return list.toString();
	}

}
