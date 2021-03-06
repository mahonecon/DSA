package tree;

public class Difference extends Expr{
	
	public Difference(Expr left, Expr right) {
		super(left, right);
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left.equals(right)) {
			return new Constant(0);
		}
		if(right instanceof Constant&&right.eval()==0)
			return left;
		return new Constant(eval());
	}
	
	public int eval() {
		return left.eval()-right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Difference))return false;
		Difference d=(Difference)obj;
		return left.equals(d.left)&&right.equals(d.right);
	}
	
	public String toString() {
		String s = "(";
		s += String.valueOf(left) + "-";
		s += String.valueOf(right);
		s += ")";
		return s;
	}

}
