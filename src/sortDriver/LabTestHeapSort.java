package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the HeapSort algorithm.
 * 
 * @author (sdb) 
 * @version (Nov 2016)
 */
public class LabTestHeapSort
{
    static ArrayList <Integer> grades = new ArrayList <Integer> ();
    static Random rand = new Random();
    
    public static void main (String[] args)
    {
    
    System.out.println ("Test Heap Sort:");
    Sorter <Integer> sorter = new HeapSort <Integer> ( );
     testSort (sorter, true);       // ascending sort
     
     System.out.println ("\nTest Selection Sort:");
     sorter = new SelectionSort();
     testSort (sorter, true);       // ascending sort
     
     /////// Uncomment the following when ready for part (c)
      System.out.println ("\nTest Heap Sort Descending:");
      sorter = new HeapSort <Integer> ( );
      testSort (sorter, false);       // descending sort
      
      
    }
    
    private static void testSort (Sorter<Integer> sorter, boolean ascending)
    {   init();
        int n = 20;

        System.out.println ("First " + n + " before sorting");
        show (n);
        if (ascending)
            sorter.sort(grades);
        else
            sorter.sortDescending(grades);
        System.out.println ("First " + n + " after sorting");
        show (n);
        check(ascending);
    
    }
    
    private static void init()
    {   grades.clear(); 
        for (int i=0; i<40000; i++)
             grades.add (rand.nextInt(25000));

    }
    
    // Print at most n values
    private static void show (int n)
    {   for (int i=0; i<n && i<grades.size(); i++)
            System.out.print (grades.get(i) + " ");
        System.out.println ();
    }
    
    private static void check(boolean ascending)
    {   if (ascending)
            checkAscending();
        else
            checkDescending();
        }
    private static void checkAscending()
    {
        for (int i=1; i<grades.size(); i++)
            {   if (grades.get(i) < grades.get(i-1))
                    System.err.println ("not sorted, index is " + i);
            }
        System.out.println ("check terminated");
    }
    private static void checkDescending()
    {   
        for (int i=1; i<grades.size(); i++)
            {   if (grades.get(i) > grades.get(i-1))
                    System.err.println ("not sorted, index is " + i);
            }
        System.out.println ("check terminated");
    }
}