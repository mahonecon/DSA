package list;

public class RefIterator<E> implements Iterator<E>
{
	LinkedList<E> list;
	Node<E> cursor;
	
	RefIterator(LinkedList<E> list)
	{
		this.list = list;
		cursor = list.head;
	}
	
	public boolean hasNext()
	{
		return cursor != list.tail.prev;
	}
	
	public boolean hasPrevious()
	{
		return cursor.prev != list.head; 
	}
	
	public E next()
	{
		cursor = cursor.next;
		return cursor.value;
	}
	
	public void remove()
	{
		cursor.next.prev = cursor.prev;
		cursor.prev.next = cursor.next;
		cursor = cursor.prev;
		list.size--;
	}
	
	public boolean hasTwoMore() {
		if(list.size() < 2) {
			return false;
		}
		if(cursor.next != list.tail.prev && cursor.next != list.tail) {
			return true;
		}
		return false;
	}
}
