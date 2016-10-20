package sortDriver;
import list.*;
import sort.*;

/**
 * Test the sort algorithm for a list of students
 * 
 * @author (sdb) 
 * @version (Oct 2014)
 */
public class DriverSortStudents
{
   
    public static void main(String[] args)
    {   List <Student> roster = new ArrayList <Student> ();
        
        roster.add (new Student ("jim", "252"));   // name and ssn, gpa = 0.0
        roster.add (new Student ("joe", "144"));
        roster.add (new Student ("al", "543"));
        roster.add (new Student ("jim", "950"));
        roster.add (new Student ("mary", "333"));
        roster.add (new Student ("jim", "303"));
        
        System.out.println (roster);
        List<Student> copy = new ArrayList<Student>(roster);
        
        Sorter<Student> sorter = new SelectionSort<Student>();
        sorter.sort(roster);
       
        System.out.println (roster);
        
        sorter = new BubbleSort <Student> ();
        sorter.sort(copy);
       
        System.out.println (copy);    
    }
        
}