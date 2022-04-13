package de.dhbwka.java.second_semester.probeklausur2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Speedy Quiz
 */
public class SpeedyQuiz {
	/**
	 * Main method, entry point of application
	 *
	 * @param args CLI arguments
	 */
	public static void main(String[] args) {
		// Set cross platform LAF to get colors for sure to work on MacOS
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Question> questionPool = loadQuestions();

		try {
			Game game = new Game(questionPool, 10);

			game.registerClient( new GameTerm("Mia", game) );
			game.registerClient( new GameTerm("Ben", game) );

			game.startGame();
		} catch (GameException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Game Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Load questions
	 *
	 * @return questions to load
	 */
	public static List<Question> loadQuestions(){
		List<Question> questions = new ArrayList<>();

		try {
			List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\probeklausur2\\questions.txt"));
			lines.stream().forEach(q -> questions.add(parseQuestion(q)));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error loading questions", JOptionPane.ERROR_MESSAGE);
		}

		return questions;
	}

	/**
	 * Parse a question from input line
	 *
	 * @param line line to parse
	 * @return created question instance
	 */
	public static Question parseQuestion( String line ){
		try {
			String[] parts = line.split(";");
				if ( parts.length == 6 ){
				String[] answers = new String[4];
				System.arraycopy(parts, 1, answers, 0, 4);
				return new Question(parts[0], answers, Integer.parseInt(parts[5]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
