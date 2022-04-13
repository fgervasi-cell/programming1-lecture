package de.dhbwka.java.second_semester.java8.soccer;

public class Player {
	private int number;
	private String name;
	private String position;
	private String birthday;
	private String club;
	private int games;
	private int goals;

	public Player(int number, String name, String position, String birthday, String club, int games, int goals) {
		setNumber(number);
		setName(name);
		setPosition(position);
		setBirthday(birthday);
		setClub(club);
		setGames(games);
		setGoals(goals);
	}
	
	static int comparePlayerByNumber(Player p1, Player p2) {
		if(p1.number < p2.number) {
			return -1;
		} else if (p1.number == p2.number) {
			return 0;
		} else {
			return 1;
		}
	}
	
	static int comparePlayerByName(Player p1, Player p2) {
		return p1.name.compareTo(p2.name);
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s, %s", number, name, position, birthday, club, games, goals);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}
}
