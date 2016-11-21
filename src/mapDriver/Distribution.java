package mapDriver;

import map.*;
import list.*;

/** Find a distribution for text */
public class Distribution {
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	public void buildMap(List<String> text) {
		Iterator<String> itty = text.iterator();
		String word;
		Integer count;
		while(itty.hasNext()) {
			word = itty.next();
			count = map.get(word);
			if(count == null) {
				map.put(word, 1);
			}
			else {
				map.put(word, count + 1);
			}
		}
	}
}
