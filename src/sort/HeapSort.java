package sort;

import list.*;

/** 
 * @author CJ Mahoney
 * @version 10 November 2016
 */
public class HeapSort<E extends Comparable> implements Sorter<E> {

	List<E> list;
	
	/** Sort the list in ascending order. */
	public void sort(List<E> list) {
		this.list = list;
		heapify(0);
		int last = list.size() - 1;
		while(last > 0) {
			swap(0, last);
			last--;
			percDown(0, last);
		}
	}
	
	/** Sort the list in descending order. */
	public void sortDescending(List<E> list) {
		this.list = list;
		heapifyDescending(0);
		int last = list.size() - 1;
		while(last > 0) {
			swap(0, last);
			last--;
			percDownDescending(0, last);
		}
	}
	
	/** Turns the list into a heap. */
	private void heapify(int root) {
		int max = list.size() - 1;
		if(root >= max) return;
		heapify(2*root+1); //2 * i + 1 == position of left child | 2 * i + 2 == position of right child
		heapify(2*root+2);
		percDown(root, max);
	}
	
	/** heapify() using the descending methods instead of ascending. */
	private void heapifyDescending(int root) {
		int max = list.size() - 1;
		if(root >= max) return;
		heapifyDescending(2*root+1);
		heapifyDescending(2*root+2);
		percDownDescending(root, max);
	}
	
	/** Percolates down using biggerChildPosition(int root, int max) */
	private void percDown(int root, int max) {
		if(2*root+1 > max) return; // No Children
		int bc = biggerChildPosition(root, max); // Position of the bigger child
		while (2*root + 1 <= max && greater(bc,root)) {
			swap(root, bc);
			root = bc;
			bc = biggerChildPosition(root, max);
		}
	}
	
	/** Percolates down using smallerChildPosition(int root, int max) instead of biggerChildPosition(int root, int max) */
	private void percDownDescending(int root, int max) {
		if(2 * root + 1 > max) return;
		int sc = smallerChildPosition(root, max);
		while (2 * root + 1 <= max && !greater(sc, root)) {
			swap(root, sc);
			root = sc;
			sc = smallerChildPosition(root, max);
		}
	}
	
	/** Swaps the positions of the first input with the second in the list */
	private void swap(int root, int bc) {
		E temp = list.get(root);
		list.set(root, list.get(bc));
		list.set(bc, temp);		
	}

	/** @return true if value at pos i is strictly greater than the value at pos j*/
	private boolean greater(int i, int j) {
		return list.get(i).compareTo(list.get(j)) > 0;		
	}
	
	/** @return the lesser of the two children */
	private int smallerChildPosition(int root, int max) {
		int left = 2*root+1;
		int right = left+1;
		if(right > max || !greater(left, right)) return left;
		return right;
	}
	
	/** @return the greater of the two children */
	private int biggerChildPosition(int root, int max) {
		int left = 2*root+1;
		int right = left+1;
		if(right > max || greater(left,right)) return left;
		return right;
	}
}
