package mapDriver;

import map.*;

public class FinalHashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> test = new HashMap<String, String>();
		test.put("First","Bill");
		test.put("Second", "Larry");
		test.put("Third", "Brett");
		test.put("Fourth", "Luke");
		test.put("Fifth", "CJ");
		test.put("Sixth", "Larry");
		test.put("Seventh", "Jon");
		test.put("Eighth", "No");
		
		System.out.println("Should be true : " + test.hasDuplicateValues());
		
		test.remove("Sixth");
		
		System.out.println("Should be false : " + test.hasDuplicateValues());
		
	}
}
