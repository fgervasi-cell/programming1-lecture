package tinf2;

public class RecursiveAddition {
	public static int add(int m, int n) {
		if(n == 0) {
			return m;
		} else {
			return add(m, n - 1) + 1;
		}
	}
	
	public static int mult(int m, int n) {
		if(n == 0 || m == 0) {
			return 0;
		} else if(m == 1) {
			return n;
		} else {
			return n + mult(n, m - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(add(5, 11));
		System.out.println(mult(5, 6));
	}
	
//	addiere2(int m, int n)
//	{
//	If(n == 0)
//	{
//	return m;
//	}
//	else
//	{
//	return addiere2(m,n-1) +1;
//	}
//	}
//
//	addiere3(int m, int n, int o)
//	{
//	return addiere2(addiere2(m,n),o));
//	}
}
