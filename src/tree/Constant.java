package tree;

public class Constant extends Expr {
	
	int value;

	public Constant(int value){
		this.value=value;
	}
	
	Constant(Expr left, Expr right) {
		super(left, right);
	}

	public Expr simplify() {
		return this;
	}

	public int eval() {
		return value;
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof Constant)) return false;
		Constant c=(Constant)obj;
		return value==c.value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}

}
