package tree;
import list.Iterator;

public class EmptyIterator<E> implements Iterator {

	public boolean hasNext() {
		return false;
	}

	public Object next() {
		return null;
	}

	public void remove() {}

}
