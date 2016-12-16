package setDriver;

import set.*;

public class FinalHashSetTest {

	public static void main(String[] args) {
		Set<String> test = new HashSet<String>();
		Set<String> test2 = new HashSet<String>();
		
		test.add("NO");
		test2.add("NO");
		test.add("FALSE");
		test2.add("FALSE");
		test.add("OK");
		test2.add("OK");
		
		System.out.println("Test and Test2 are equal: " + test.equals(test2));
		
		test.add("TRUE");
		test.add("GOLDEN");
		test.add("IT WORKS");
		
		test2.add("You're Smart");
		test2.add("You're Loyal");
		test2.add("You're Perfect");
		
		System.out.println("Test and Test2 aren't equal anymore: " + !test.equals(test2));
		
		Set<String> test3 = test.difference(test2);
		
		System.out.println("Test : " + test);
		System.out.println("Test2 : " + test2);
		System.out.println("Difference of test and test2 : " + test3);
		
		test3 = test2.difference(test);
		
		System.out.println("Difference of test2 and test : " + test3);
	}
}
