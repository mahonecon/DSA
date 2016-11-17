package hashDriver;

public class Student {
	String name;
	String idNumber;
	int cr;
	HomeTown home;
	
	
	public Student(String name, String id, int cr, HomeTown home) {
		this.name = name;
		idNumber = id;
		this.cr = cr;
		this.home = home;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) {
			return false;
		}
		Student s = (Student) obj;
		return s.cr == cr && s.name.equals(name) && s.home.equals(home);
	}
	
	public int hashCode() {
		int code = 17;
		code = code * 31 + cr;
		code = code * 31 + name.hashCode();
		code = code * 31 + home.hashCode();
		return code;
	}
	
	public String toString() {
		String str = name;
		str += "(" + idNumber + ") ";
		str += cr + " cr ";
		str += home;
		return str;
	}
}
