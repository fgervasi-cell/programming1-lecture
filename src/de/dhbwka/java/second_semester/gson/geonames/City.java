package de.dhbwka.java.second_semester.gson.geonames;

public class City {
	private String fcodeName;
	private String toponymName;
	private String countryCode;
	private String fcl;
	private String fclName;
	private String name;
	private String wikipedia;
	private double lng;
	private String fcode;
	private int geonameId;
	private double lat;
	private int population;
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", 
				fcodeName, toponymName, countryCode, fcl, fclName, name, 
				wikipedia, lng, fcode, geonameId, lat, population);
	}
	
}
