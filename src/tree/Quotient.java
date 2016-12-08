package tree;

public class Quotient extends Expr{
	
	public Quotient(Expr left, Expr right) {
		super(left, right);
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left.equals(right))
			return new Constant(1);
		if(left instanceof Variable && right instanceof Variable)
			return this;
		if(right instanceof Constant&&right.eval()==1)
			return left;
		if(right instanceof Constant&&right.eval()==0)
			return null;
		if(left instanceof Constant&&left.eval()==0)
			return new Constant(0);
		if(left instanceof Product) {
			Expr x = left.left;
			Expr y = left.right;
			if(right.equals(y)) {
				return x;
			}
		}
		return new Constant(eval());
	}
	
	public int eval() {
		return left.eval()/right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Quotient))return false;
		Quotient q=(Quotient)obj;
		return left.equals(q.left)&&right.equals(q.right);
	}
	
	public String toString() {
		return String.valueOf("(" + left + "/" + right + ")");
	}

}
