package de.dhbwka.java.second_semester.enums;

public enum Months {
	JANUAR(31, "Hartung", "Eismond"),
	FEBRUAR(28, "Hornung", "Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester"),
	MAERZ(31, "Lenzing", "Lenzmond"),
	APRIL(30, "Launing", "Ostermond"),
	MAI(31, "Winnemond", "Blumenmond"),
	JUNI(30, "Brachet", "Brachmond"),
	JULI(31, "Heuert", "Heumond"),
	AUGUST(31, "Ernting", "Erntemond", "Bisemond"),
	SEPTEMBER(30, "Scheiding", "Herbstmond"),
	OKTOBER(31, "Gilbhart", "Gilbhard", "Weinmond"),
	NOVEMBER(30, "Nebelung", "Windmond", "Wintermond"),
	DEZEMBER(31, "Julmond", "Heilmond", "Christmond", "Dustermond");
	
	private int days;
	private String[] oldGerman;
	
	Months(int days, String... oldGerman) {
		this.days = days;
		this.oldGerman = oldGerman;
	}
	
	private String getOldGermanNames() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < this.oldGerman.length; i++) {
			if(i == this.oldGerman.length - 1) {
				builder.append(this.oldGerman[i]);
			} else {
				builder.append(this.oldGerman[i] + ", ");
			}
		}
		return builder.toString();
	}
	
	@Override
	public String toString() {
		return String.format("Der %s hat %d Tage und hieß frueher \"%s\"", this.name().charAt(0) + this.name().substring(1).toLowerCase(), days, getOldGermanNames());
	}
}
