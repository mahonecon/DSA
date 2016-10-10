package recursion;

import java.util.HashSet;
import java.util.Set;
import list.*;

/** This class will test the permutation generator
 *  @author sdb
 *  @version Sep 2015
   */
public class PermDriver 
{
  public static void main (String [] args)
  { List <Character> input = new LinkedList <Character> ();
//        for (int i=0; i<args[0].length(); i++)
//            input.add(args[0].charAt(i));

        Set <List <Character>> output = Permutations.generatePerms(input);

        System.out.println (output);
        System.out.println (output.size() + " permutations");
   }
}
        