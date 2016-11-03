package tree;

public class Mod extends Expr{
	
	public Mod(Expr left, Expr right) {
		super(left, right);
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left.equals(right)) {
			return new Constant(0);
		}
		if(left instanceof Variable && right instanceof Variable)
			return this;
		if(left instanceof Constant && left.eval() == 1)
			return new Constant(1);
		if(right instanceof Constant && right.eval() == 1)
			return new Constant(0);
		if(left instanceof Constant && left.eval() == 0)
			return new Constant(0);
		if(right instanceof Constant && right.eval() == 0)
			return null;
		return new Constant(eval());
	}
	
	public int eval() {
		return left.eval() % right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Mod)) return false;
		Mod m = (Mod)obj;
		return left.equals(m.left) && right.equals(m.right);
	}
	
	public String toString() {
		return String.valueOf("(" + left + "%" + right + ")");
	}

}
