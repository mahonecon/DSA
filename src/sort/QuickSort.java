package sort;
import list.*;

public class QuickSort<E extends Comparable> implements Sorter<E> {

	List<E> list;
	
	/* [1, 3, 5, 6, 7, 9]
	 * a) 5
	 * b) n-1
	 * c) 
	 * d) [9,8,7,6,5,4]
	 */
	
	
	public void sort(List<E> list){
		this.list=list;
		qSort(0,list.size()-1);
	}
	
	private void qSort(int start, int end){
		if(end-start<1)
			return;
		int mid=(start+end)/2;
		int p=partition(start,mid);
		qSort(start,p-1);
		qSort(p+1,end);
		int q=partition(mid,end);
		qSort(start,q-1);
		qSort(q+1,mid);
	}
	
	private int partition(int start, int end){
		E pivotValue=list.get(start);
		int p=start;
		for(int i=start+1;i<=end;i++){
			if(list.get(i).compareTo(pivotValue)<0){
				list.set(p, list.get(i));
				p++;
				list.set(i, list.get(p));}}
			list.set(p, pivotValue);
			return p;}
}
