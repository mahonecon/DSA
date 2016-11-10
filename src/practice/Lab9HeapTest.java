package practice;

import list.*;
import sort.*;

public class Lab9HeapTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("al");
		list.add("ben");
		list.add("joe");
		list.add("al");
		list.add("chas");
		list.add("mary");
		list.add("ben");
//		list.add(4);
//		list.add(5);
//		list.add(1);
//		list.add(4);
//		list.add(5);
		
		Sorter<String> sorter = new HeapSort<String>();
		
		System.out.println("Before Sorting:");
		System.out.println(list);
		sorter.sort(list);
		System.out.println("After Sorting:");
		System.out.println(list);
	}

}
