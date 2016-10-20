package sort;
import list.*;

public class BinarySearch<E extends Comparable> {
	List<E> list;
	E target;
	
	public BinarySearch(List<E> list) {
		this.list = list;
	}
	
	public int search(E target) {
		this.target = target;
		return binSrch(0, list.size()-1);
	}
	
	private int binSrch(int lo, int hi) {
		if(lo > hi)
			return -1;
		int mid = (lo + hi)/2;
		int cmp = target.compareTo(list.get(mid));
		if(cmp == 0)
			return mid;
		else if(cmp < 0)
			return binSrch(lo, mid - 1);
		else
			return binSrch(mid + 1, hi);
	}
}
