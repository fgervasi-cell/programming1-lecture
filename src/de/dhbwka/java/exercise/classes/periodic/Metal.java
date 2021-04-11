package de.dhbwka.java.exercise.classes.periodic;

public class Metal extends Element {
	private boolean metalloid;
	private double conductivity;

	public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean isMainGroup, boolean metalloid,
			double conductivity) {
		super(name, symbol, ordinal, shell, phase, isMainGroup);
		setMetalloid(metalloid);
		setConductivity(conductivity);
	}

	@Override
	public String toString() {
		if (metalloid) {
			return super.toString() + ", Halbleiter, \u03A3: " + this.conductivity;
		} else {
			return super.toString() + ",  \u03C3: " + this.conductivity;
		}
	}

	public void setMetalloid(boolean metalloid) {
		this.metalloid = metalloid;
	}

	public boolean getMetalloid() {
		return this.metalloid;
	}

	public void setConductivity(double conductivity) {
		this.conductivity = conductivity;
	}

	public double getConductivity() {
		return this.conductivity;
	}

}
