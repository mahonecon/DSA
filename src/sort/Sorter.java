package sort;
import list.*;

/** Arrange the items in a List in ascending order. */
public interface Sorter<E extends Comparable> 
{void sort(List<E> list);}
