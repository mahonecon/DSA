package list;

public class ArrayIterator<E> implements Iterator<E>
{
	int cursor = -1;
	List<E> list; 
	
	ArrayIterator(List<E> list)
	{
		this.list = list;
	}
	
	public boolean hasNext()
	{
		return cursor < list.size() - 1;
	}
	
	public E next()
	{
		cursor++;
		return list.get(cursor);
	}
	
	public void remove()
	{
		list.remove(cursor);
		cursor--;
	}
	
	public boolean hasTwoMore() {
		if(list.size() < 2)
			return false;
		if(!((list.size() - cursor) > 2))
			return false;
		return true;
	}
}
