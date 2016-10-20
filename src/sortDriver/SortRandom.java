package sortDriver;
import list.*;
import sort.*;
import java.util.Random;

/**
 * Test the sort algorithm for a list of students
 * 
 * @author (sdb) 
 * @version (Oct 2016)
 */
public class SortRandom
{
   
    public static void main(String[] args)
    {   final long startTime = System.nanoTime();
    	List <Integer> numbers = new ArrayList <Integer> ();
        Random rand = new Random();     // Random number generator
        
        for (int i=0; i<2000; i++)
            numbers.add (rand.nextInt());
        
        Sorter <Integer> sorter = new BubbleSort <Integer> ();
        sorter.sort(numbers);
        
        // Show the first 20 values in the List
        Iterator<Integer> itty = numbers.iterator();
        for (int i=0; i<20; i++)
            System.out.println (itty.next() + " ");
        final long duration = System.nanoTime() - startTime;
        System.out.println("\nTime: " + (duration / 1000000000) + " second(s)");
        
    }
        
}