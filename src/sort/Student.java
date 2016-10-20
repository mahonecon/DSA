package sort;

public class Student implements Comparable<Student> {

	private String name, ssn;
	private float GPA;
	public Student(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
		GPA = 0;
	}
	
	public int compareTo(Student s) {
		if(!s.name.equals(name)) {
			return name.compareTo(s.name);
		}
		if(!s.ssn.equals(ssn)) {
			return ssn.compareTo(s.ssn);
		}
		if(s.GPA == GPA) {
			return 0;
		}
		if(s.GPA < GPA) {
			return 1;
		}
		return -1;
	}
	
	public String toString() {
		String s = ("Name: " + name + " | SSN: " + ssn + " | GPA: " + GPA);
		return s;
	}
}
