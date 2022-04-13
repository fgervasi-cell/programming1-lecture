package de.dhbwka.java.second_semester.java8.soccer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Soccer {

	private static final String FILE_PATH = "C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\soccer\\players.txt";
	private static List<Player> players = new ArrayList<>();

	public static void main(String[] args) {
		try { 
			List<String> lines = Files.readAllLines(Paths.get(FILE_PATH), StandardCharsets.ISO_8859_1);
			lines.stream().map(l -> l.split(";")).map(l -> new Player(Integer.parseInt(l[0]), l[1], l[2], l[3], l[4],
					Integer.parseInt(l[5]), Integer.parseInt(l[6]))).forEach(players::add);
			System.out.println("Players sorted by number:");
			players.stream().sorted((p1, p2) -> Player.comparePlayerByNumber(p1, p2)).forEach(System.out::println); 
			System.out.println(); 
			System.out.println("Players with more than 50 games, sorted by name:"); 
			players.stream().filter(p -> p.getGames() > 50) .sorted((p1, p2) -> Player.comparePlayerByName(p1, p2)).forEach(System.out::println);
			System.out.println();
			System.out.println("All clubs of the players:");
			players.stream().forEach(p -> {
				System.out.println(p.getClub());
			});
			System.out.println();
			System.out.println("Count of players with less than 5 goals: " + players.stream().filter(p -> p.getGoals() < 5).count());
			System.out.println("Count of goals of all players: " + players.stream().mapToInt(Player::getGoals).sum());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
