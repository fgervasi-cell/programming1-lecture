package de.dhbwka.java.exercise.classes.horner;

public class Main {

	public static void main(String[] args) {
		double[] example2Array = new double[5];
		example2Array[0] = 2.0;
		example2Array[1] = -4.0;
		example2Array[2] = -5.0;
		example2Array[3] = 7.0;
		example2Array[4] = 11.0;
		Horner example2 = new Horner(4, example2Array);
		System.out.println("Example2:");
		System.out.println(example2);
		System.out.println("f(2)=" + example2.getValue(2.0));
		System.out.println("Polynom of 3rd grade:");
		double[] operandsForCustomThirdGradePolynom = new double[4];
		operandsForCustomThirdGradePolynom[0] = 5;
		operandsForCustomThirdGradePolynom[1] = 3.7;
		operandsForCustomThirdGradePolynom[2] = -10.76;
		operandsForCustomThirdGradePolynom[3] = 0.5;
		Horner customThirdGradePolynom = new Horner(3, operandsForCustomThirdGradePolynom);
		System.out.println(customThirdGradePolynom);
		System.out.println("Random polynom:");
		System.out.println(new Horner());
		Horner randomPolynominal1 = new Horner();
		Horner randomPolynominal2 = new Horner();
		Horner randomPolynominal3 = new Horner();
		System.out.println("Funktionswert Random1:" + randomPolynominal1);
		System.out.println("f(7)=" + randomPolynominal1.getValue(7));
		System.out.println("f(1.5)=" + randomPolynominal1.getValue(1.5));
		System.out.println("f(-3)=" + randomPolynominal1.getValue(-3));
		System.out.println("Funktionswert Random2:" + randomPolynominal2);
		System.out.println("f(7)=" + randomPolynominal2.getValue(7));
		System.out.println("f(1.5)=" + randomPolynominal2.getValue(1.5));
		System.out.println("f(-3)=" + randomPolynominal2.getValue(-3));
		System.out.println("Funktionswert Random3:" + randomPolynominal3);
		System.out.println("f(7)=" + randomPolynominal3.getValue(7));
		System.out.println("f(1.5)=" + randomPolynominal3.getValue(1.5));
		System.out.println("f(-3)=" + randomPolynominal3.getValue(-3));
		double[] exampleArray = new double[11];
		exampleArray[0] = 0.5;
		exampleArray[1] = -3.0;
		exampleArray[2] = 2.0;
		exampleArray[3] = 4.0;
		exampleArray[4] = 3.0;
		exampleArray[5] = -10.0;
		exampleArray[6] = 8.0;
		exampleArray[7] = 4.5;
		exampleArray[8] = 3.0;
		exampleArray[9] = -2.0;
		exampleArray[10] = 1.0;
		Horner example = new Horner(10, exampleArray); 
		System.out.println("Example:" + example);
		System.out.println("f(1.5)=" + example.getValue(1.5));
	}

}
