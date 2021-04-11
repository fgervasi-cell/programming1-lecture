package de.dhbwka.java.exercise.classes.horner;

import java.util.Random;

public class Horner {

	private int functionalGrade;
	private double[] operands;

	public Horner() {
		Random random = new Random();
		this.functionalGrade = random.nextInt(11);
		this.operands = new double[this.functionalGrade + 1];
		for (int i = 0; i < this.operands.length; i++) {
			this.operands[i] = (double) Math.round((random.nextDouble() * 10000)) / 100;
		}
		new Horner(this.functionalGrade, this.operands);
	}

	public Horner(int functionalGrade, double[] operands) {
		this.functionalGrade = functionalGrade;
		this.operands = operands;
	}

	public double getValue(double x) {
		double functionalValue = 0;
		for (int i = 0; i < functionalGrade; i++) {
			if (i == 0) {
				functionalValue += (this.operands[i] * x) + this.operands[i + 1];
			} else if (i == functionalGrade - 1) {
				functionalValue *= x;
				functionalValue += this.operands[this.operands.length - 1];
			} else {
				functionalValue *= x;
				functionalValue += this.operands[i + 1];
			}
		}
		return functionalValue;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		int exponent = this.functionalGrade;
		for (int i = 0; i < this.functionalGrade; i++) {
			if (this.operands[i] >= 0 && i > 0) {
				strBuilder.append("+" + this.operands[i]);
			} else {
				strBuilder.append(this.operands[i]);
			}
			strBuilder.append("x^" + exponent--);
		}
		if (this.operands[this.functionalGrade] >= 0) {
			strBuilder.append("+" + this.operands[this.functionalGrade]);
		} else {
			strBuilder.append(this.operands[this.functionalGrade]);
		}
		return strBuilder.toString();
	}

	public int getFunctionalGrade() {
		return this.functionalGrade;
	}

	public double[] getOperands() {
		return this.operands;
	}
}
