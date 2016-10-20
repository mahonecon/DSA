package recursion;

/**
 * Arithmetic class
 * @author CJ Mahoney
 * @version 10/20/2016
 */
public class Arithmetic {
	public static void main(String [] args)
	{  test (3,5);
	   test (25,3);
	   test (10,2);
	}
	 
	private static void test (int x, int y)
	 {   System.out.println (x + "*" + y + " = " + multiply(x,y));
	     System.out.println (y + "*" + x + " = " + multiply(y,x));
	     System.out.println (x + "%" + y + " = " + mod(x,y));
	     System.out.println (y + "%" + x + " = " + mod(y,x));
	 }
	
	/** @return the remainder when a is divided by b
    Pre:  The parameters a and b are both positive */
	public static int mod(int a, int b) {
		if(a < b)
			return a;
		else
			return mod((a-b), b);
	}
	
	/** @return the product when a is multiplied by b
	 * Pre: a is not negative */
	public static int multiply(int a, int b) {
		if(a == 0) 
			return 0;
		return b + multiply(a -1, b);
	}

}
