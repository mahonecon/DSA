package queueDriver;

import java.util.Random;
import queue.*;

/**
 * Simulate print queues and print jobs assigned to queues.
 * Shorter print jobs are handled first.
 * 
 * @author (sdb) 
 * @version (Apr 2015)
 */
public class PrintPriorityQueues
{
	public static void main(String[] args) {
		QueueADT<Integer>  pq = new PriorityQueue <Integer> ( );
	    pq.add(4); 
	    pq.add(5); 
	    pq.add(6); 
	    pq.add(20); 
	    pq.add(15); 
	    pq.add(8);
	    pq.add(7) ; 
	    pq.remove();
	    
	    System.out.println("[15,7,8,4,6,5]");
	    System.out.println("O(log(n)) remove");
	    System.out.println("O(log(n)) add");
		
//		Printer printer1;
//		printer1 = new Printer (3, "ROB 312");           // print speed is 3 blocks per step
//		printer1.add (new Doc (13));
//        printer1.add (new Doc(7));
//        printer1.add (new Doc(5));
//        
//        for (int i=0; i<3; i++)                     // 3 steps
//            printer1.print ();
//        
//        printer1.add (new Doc (12));
//        
//        for (int i=0; i<25; i++)                    // 25 more steps
//            printer1.print ();
    } 
  
}