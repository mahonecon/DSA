package tree;

public class Variable extends Expr{
	
	Constant right = null;
	char name;
	 
	public Variable(Expr left, Expr right) {
		this.left = left;
		this.right = (Constant)right;
	}
	
	public Variable(char name) {
		this.name = name;
	}
	
	public Expr simplify() {
		return this;
	}
	
	public int eval() {
		if(right != null)
			return right.eval();
		throw new IllegalArgumentException();
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
