package tree;

public class Sum extends Expr {
	
	public Sum (Expr left, Expr right){
		super(left, right);
	}
	
	public Expr simplify(){
		left=left.simplify();
		right=right.simplify();
		if(left instanceof Variable && right instanceof Variable)
			return this;
		if(right instanceof Constant&&right.eval()==0)
			return left;
		if(left instanceof Constant&&left.eval()==0)
			return right;
		return new Constant(eval());
	}

	public int eval() {
		return left.eval()+right.eval();
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof Sum))return false;
		Sum s=(Sum)obj;
		return left.equals(s.left)&&right.equals(s.right)||left.equals(s.right)&&right.equals(s.left);
	}
	
	public String toString() {
		String s = "(";
		s += String.valueOf(left) + "+";
		s += String.valueOf(right);
		s += ")";
		return s;
	}

}
