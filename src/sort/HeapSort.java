package sort;

import list.*;

public class HeapSort<E extends Comparable> implements Sorter<E> {

	List<E> list;
	
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
	
	private void heapify(int root) {
		int max = list.size() - 1;
		if (root >= max) return;
		heapify(2*root+1); //2*i + 1 == position of left child | 2*i + 2 == position of right child
		heapify(2*root+2);
		percDown(root, max);
	}
	
	private void percDown(int root, int max) {
		if(2*root+1 > max) return; // No Children
		int bc = biggerChildPosition(root, max); //Position of the bigger child
		while (2*root + 1 <= max && greater(bc,root)) {
			swap(root, bc);
			root = bc;
			bc = biggerChildPosition(root, max);
		}
	}
	
	private void swap(int root, int bc) {
		// TODO Auto-generated method stub
		
	}

	/** @return true if value at pos i is strictly greater than the value at pos j*/
	private boolean greater(int i, int j) {
		return list.get(i).compareTo(list.get(j)) > 0;
		
	}
	
	private int biggerChildPosition(int root, int max) {
		int left = 2*root+1;
		int right = left+1;
		if(right > max || greater(left,right)) return left;
		return right;
	}
}
