package recursion;


import java.util.HashSet;
import java.util.Set;
import list.*;

public class Permutations {	
	/** @return The set of all permutations of the given list.
	 *  Pre:  The given list is not empty. */
	public static Set<List<Character>>  generatePerms(List<Character> list) {
		
		Set<List<Character>> set = new HashSet<List<Character>>();
		if(list.size() == 1) {
			set.add(list);
			return set;
		} else {
			
		}
		return set;
	}
}
