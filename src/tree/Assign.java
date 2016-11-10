package tree;

public class Assign extends Expr{
		
	public Assign(Expr left, Expr right) {
		super(left,right);
		left.right = new Constant(right.eval());
	}

	public Expr simplify() {
		right = right.simplify();
		left = left.simplify();
		return left = right;
	}

	public int eval() {
		return right.eval();
	}

	public boolean equals(Object obj) {
		if(obj instanceof Assign) {
			Assign a = (Assign) obj;
			if(a.left.equals(left)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return String.valueOf("(" + left.simplify() + "=" + right.simplify() + ")");
	}
}
