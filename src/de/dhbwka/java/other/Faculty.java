package de.dhbwka.java.other;

public class Faculty {
	public static void main(String[] args) {
		int x = 4;
		System.out.println(fac(x));
	}
	
	private static int fac(int n) {
		if(n == 1) {
			return 1;
		} else {
			n -= 1;
			return fac(n) * (n + 1);
		}
	}
}
