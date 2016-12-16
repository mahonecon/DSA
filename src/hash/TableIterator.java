package hash;
import list.Iterator;
/**
 * An iterator to sort a HashTable
 * @author CJ Mahoney
 *
 */

public class TableIterator<E> implements Iterator<E> {
	int ndx; //which linked list.
	Iterator<E> itty; //for a LinkedList
	HashTable<E> table;
	
	public TableIterator(HashTable<E> table) {
		this.table = table;
		itty = table.lists.get(0).iterator();
	}
	
	public boolean hasNext() {
		if (itty.hasNext())
			return true;
		for(ndx++; ndx < table.lists.size();) {
			if(table.lists.get(ndx).isEmpty()) {
				setItty(ndx);
				return true;
			}
		} 
		return false;		
	}
	
	public E next() {
		hasNext();
		return itty.next();
	}
	
	private void setItty(int ndx) {
		itty = table.lists.get(ndx).iterator();
		table.keyCount--;
	}
	
	public void remove() {
		itty.remove();
	}

	public boolean hasTwoMore() {
		if(table.lists.size() < 2) {
			return false;
		}
		if(!((table.lists.size() - ndx) > 2)) {
			return false;
		}
		return true;
	}
}