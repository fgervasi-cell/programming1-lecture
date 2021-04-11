package de.dhbwka.java.exercise.classes.complex;

import java.util.Random;

public class Complex {

	private double real;
	private double imag;

	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public double getImag() {
		return imag;
	}

	public static Complex add(Complex comp1, Complex comp2) {
		return new Complex(comp1.getReal() + comp2.getReal(), comp1.getImag() + comp2.getImag());
	}

	public static Complex sub(Complex comp1, Complex comp2) {
		return new Complex(comp1.getReal() - comp2.getReal(), comp1.getImag() - comp2.getImag());
	}

	public static Complex mult(Complex comp1, Complex comp2) {
		return new Complex((comp1.getReal() * comp2.getReal()) - (comp1.getImag() * comp2.getImag()),
				(comp1.getReal() * comp2.getImag()) + (comp1.getImag() * comp2.getReal()));
	}

	public static Complex div(Complex comp1, Complex comp2) {
		return new Complex(
				(comp1.getReal() * comp2.getReal()) + (comp1.getImag() * comp2.getImag())
						/ (Math.pow(comp2.getReal(), 2) + Math.pow(comp2.getImag(), 2)),
				(comp1.getImag() * comp2.getReal()) - (comp1.getReal() * comp2.getImag())
						/ (Math.pow(comp2.getReal(), 2) + Math.pow(comp2.getImag(), 2)));
	}

	@Override
	public String toString() {
		return real + " + " + imag + "i";
	}
	
	public static Complex[] random(int randoms) {
		Random random = new Random();
		Complex[] complexArray = new Complex[randoms];
		for (int i = 0; i < randoms; i++) {
			complexArray[i] = new Complex(random.nextDouble() * 100.0, random.nextDouble() * 100.0);
		}
		return complexArray;
	}
	
	public double getMagnitude() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
	}
	
	public static boolean isLess(Complex comp1, Complex comp2) {
		return comp1.getMagnitude() < comp2.getMagnitude();
	}
	
	public static boolean isGreater(Complex comp1, Complex comp2) {
		return comp1.getMagnitude() > comp2.getMagnitude();
	}
	
	public static String compareSize(Complex comp1, Complex comp2) {
		if (comp1.getMagnitude() > comp2.getMagnitude()) {
			return "comp1 > comp2";
		} else if (comp2.getMagnitude() > comp1.getMagnitude()) {
			return "comp2 > comp1";
		} else {
			return "comp1 = comp2";
		}
	}

}
