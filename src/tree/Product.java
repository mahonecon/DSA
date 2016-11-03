package tree;

public class Product extends Expr{

	public Product(Expr left, Expr right){
		this.left=left;
		this.right=right;
	}

	public Expr simplify() {
		left=left.simplify();
		right=right.simplify();
		if(right instanceof Constant&&right.eval()==1)
			return left;
		if(left instanceof Constant&&left.eval()==1)
			return right;
		if(right instanceof Constant&&right.eval()==0)
			return new Constant(0);
		if(left instanceof Constant&&left.eval()==0)
			return new Constant(0);
		return new Constant(eval());
	}

	public int eval() {
		return left.eval()*right.eval();
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof Product))return false;
		Product p=(Product)obj;
		return left.equals(p.left)&&right.equals(p.right)||left.equals(p.right)&&right.equals(p.left);
	}
	
	public String toString() {
		return String.valueOf("(" + left + "*" + right + ")");
	}

}
