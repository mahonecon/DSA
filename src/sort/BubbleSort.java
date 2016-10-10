package sort;

import list.*;

/** Compares and sorts values by comparing to neighbors. List should be an ArrayList. */
public class BubbleSort<E extends Comparable> implements Sorter<E> {
List<E> list;

	public void sort(List<E> list) {
		this.list = list;
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = 0; j < list.size() - 1; j++) {
				if(list.get(j).compareTo(list.get(j + 1)) > 0) {
					swap(j, j + 1);
				}
			}
		}
	}
	
	private void swap(int x, int y) {
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}

}
