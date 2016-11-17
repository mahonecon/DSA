package hashDriver;

public class HomeTown {
	private String name;
	private String state;
	private String zip;
	
	public HomeTown(String name, String state, String zip) {
		this.name = name;
		this.state = state;
		this.zip = zip;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof HomeTown) {
			HomeTown h = (HomeTown) obj;
			if(h.zip.equals(zip)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String str = name + ", ";
		str += state + " ";
		str += zip;
		return str;
	}
	
	public int hashCode() {
		int code = 17;
		code = code * 31 + zip.hashCode();
		return code;
	}
}
