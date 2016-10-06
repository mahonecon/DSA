package list;

public interface Iterator<E> 
{
	/** @return true if there are more items */
	boolean hasNext();
	
	/** @ return the value of next item Pre: hasNext()*/
	E next();
	
	/** remove last item returned by a call to next() */
	void remove();
	
	/** @return true if there are two more values in the List<E> that is being iterated.*/
	boolean hasTwoMore();
}
