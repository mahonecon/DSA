package sort;
import list.*;

/** Implement Selection Sort Algorithm.  List should be ArrayList, not LinkedList. */
public class SelectionSort<E extends Comparable> implements Sorter<E> {
List<E> list;

public void sort(List<E> list) {
	this.list = list;
	for(int start = 0; start < list.size() - 1; start++) {
		swap(start,posSmallest(start));
	}
}

private int posSmallest(int start) {
	int result = start;
	for(int i = start + 1; i < list.size(); i++) {
		E temp1 = list.get(i);
		E temp2 = list.get(result);
		if(temp1.compareTo(temp2) < 0) {
			result = i;
		}
	}
	return result;
}

private void swap(int x, int y) {
	E temp = list.get(x);
	list.set(x, list.get(y));
	list.set(y, temp);
}

}
