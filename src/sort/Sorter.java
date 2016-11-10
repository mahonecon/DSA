package sort;
import list.*;


public interface Sorter<E extends Comparable> 
{
	/** Arrange the items in a List in ascending order. */
	void sort(List<E> list);
	
	/** Sort the given list in descending order */
	void sortDescending(List<E> list);
}
