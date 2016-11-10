package tree;

public class Variable extends Expr{
	
	int value;
	char name;
	 
	public Variable(char name) {
		this.name = name;
	}
	
	public Expr simplify() {
		return this;
	}
	
	public int eval() {
		if(right == null)
			throw new IllegalArgumentException();
		return right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Variable)) return false;
		Variable v = (Variable) obj;
		return v.name == name;
	}
	
	public String toString() {
		return String.valueOf(name);
	}
}
