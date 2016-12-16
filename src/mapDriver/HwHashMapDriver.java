package mapDriver;
import map.*;

/**
 * Test the HashMap
 * 
 * @author (sdb) 
 * @version (Apr 2015)
 */
public class HwHashMapDriver
{
    public static void main(String[] args)
    {   Map <String, String> names = new HashMap <String, String> ();

        assert names.isEmpty() : "isEmpty incorrect";
        
        names.put ("sue", "609");
        names.put ("jim", "856");
        names.put ("sarah", "215");
        names.put ("will", "856");
        names.put ("stu", "609");
        names.put ("van", "856");
        names.put ("jim", "215");
        
        assert ! names.isEmpty() : "isEmpty incorrect";
        assert names.containsKey ("van") : "containsKey incorrect";
        assert ! names.containsKey ("joe") : "containsKey incorrect";
        assert names.size() == 6 : "Size is incorrect" ;
        assert names.get ("jim").equals ("215") : "Incorrect value for jim" ;
        
        System.out.println ("sue's area code is " + names.remove ("sue"));
        assert names.size() == 5 : "Size is incorrect" ;
        assert names.get ("sue") == null : "Incorrect value for sue" ;
        
        System.out.println(names.size());
        System.out.println (names);     // Hint: Entry needs a toString() method
}
  
}