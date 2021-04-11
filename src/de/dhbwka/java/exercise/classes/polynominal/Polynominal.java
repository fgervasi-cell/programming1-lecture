package de.dhbwka.java.exercise.classes.polynominal;

public class Polynominal {
	private double coefficientA;
	private double coefficientB;
	private double operandC;

	Polynominal() {
		setCoefficientA(1.0);
		setCoeffiientB(1.0);
		setOperandC(1.0);
	}

	Polynominal(double coefficientA, double coefficientB, double operandC) {
		this.setCoefficientA(coefficientA);
		this.setCoeffiientB(coefficientB);
		this.setOperandC(operandC);
	}

	public double getCoeffiientB() {
		return coefficientB;
	}

	public void setCoeffiientB(double coeffiientB) {
		this.coefficientB = coeffiientB;
	}

	public double getCoefficientA() {
		return coefficientA;
	}

	public void setCoefficientA(double coefficientA) {
		this.coefficientA = coefficientA;
	}

	public double getOperandC() {
		return operandC;
	}

	public void setOperandC(double operandC) {
		this.operandC = operandC;
	}

	@Override
	public String toString() {
		if (coefficientB >= 0 && operandC >= 0) {
			return coefficientA + "x^2 +" + coefficientB + "x +" + operandC;
		} else if (coefficientB < 0 && operandC >= 0) {
			return coefficientA + "x^2 " + coefficientB + "x +" + operandC;
		} else if (coefficientB >= 0 && operandC < 0) {
			return coefficientA + "x^2 +" + coefficientB + "x " + operandC;
		} else {
			return coefficientA + "x^2 " + coefficientB + "x " + operandC;
		}
	}
	
	public Polynominal addPolynom(Polynominal polynominal) {
		return new Polynominal(coefficientA + polynominal.coefficientA, coefficientB + polynominal.coefficientB, operandC + polynominal.operandC);
	}
	
	public Polynominal multiplicationWithScalar(double scalar) {
		return new Polynominal(coefficientA * scalar, coefficientB * scalar, operandC * scalar);
	}
	
	public double[] calculateZeropoints() {
		double[] zeroesArray = new double[2];
		double zero1 = (-coefficientB + Math.sqrt(Math.pow(coefficientB, 2) - (4 * coefficientA * operandC))) / (2 * coefficientA);
		double zero2 = (-coefficientB - Math.sqrt(Math.pow(coefficientB, 2) - (4 * coefficientA * operandC))) / (2 * coefficientA);
		zeroesArray[0] = zero1;
		zeroesArray[1] = zero2;
		return zeroesArray;
	}

	public double calculateFunctionalValueOf(double value) {
		return (coefficientA * Math.pow(value, 2) + coefficientB * value + operandC);
	}
}
