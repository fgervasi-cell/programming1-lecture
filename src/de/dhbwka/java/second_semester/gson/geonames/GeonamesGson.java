package de.dhbwka.java.second_semester.gson.geonames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class GeonamesGson {
	public static void main(String[] args) {
		try {
			StringBuilder builder = new StringBuilder();
			URL url = new URL("https://www.iai.kit.edu/javavl/data/static/cities.json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
			String line = "";
			while((line = reader.readLine()) != null) {
				builder.append(line).append(System.lineSeparator());
			}
			reader.close();
			Gson gson = new Gson();
			GeonamesObject geonames = gson.fromJson(builder.toString(), GeonamesObject.class);
			geonames.getGeonames().forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
