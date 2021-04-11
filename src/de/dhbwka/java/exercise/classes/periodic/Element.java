package de.dhbwka.java.exercise.classes.periodic;

public class Element {
	private String name;
	private String symbol;
	private int ordinal;
	private char shell;
	private int phase;
	private boolean isMainGroup;

	public Element(String symbol, String name, int ordinal, char shell, int phase, boolean isMainGroup) {
		setName(name);
		setSymbol(symbol);
		setOrdinal(ordinal);
		setShell(shell);
		setPhase(phase);
		setIsMainGroup(isMainGroup);
	}

	@Override
	public String toString() {
		return this.name + " (" + this.symbol + "," + this.ordinal + ") Schale: " + this.shell + ", " + this.getPhase() + ", Gruppe: " + this.getIsMainGroup();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Element) {
			Element e = (Element) o;
			if (this.ordinal == e.getOrdinal()) {
				return true;
			}
		}
		return false;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public int getOrdinal() {
		return this.ordinal;
	}

	public void setShell(char shell) {
		this.shell = shell;
	}

	public char getShell() {
		return this.shell;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public String getPhase() {
		if (this.phase == 1) {
			return "fest";
		} else if (this.phase == 2) {
			return "flüssig";
		} else {
			return "gasförmig";
		}
	}

	public void setIsMainGroup(boolean isMainGroup) {
		this.isMainGroup = isMainGroup;
	}

	public String getIsMainGroup() {
		if (isMainGroup) {
			return "Hauptgruppe";
		} else {
			return "Nebengruppe";
		}
	}
}
