package tree;

public abstract class Expr {

	Expr left,right;
	
	Expr(Expr left,Expr right){
		this.left=left;
		this.right=right;
	}
	
	Expr(){}
	
	public abstract Expr simplify();
	
	public abstract int eval();
	
	public abstract boolean equals(Object obj);
}
