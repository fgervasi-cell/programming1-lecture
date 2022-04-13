package de.dhbwka.java.second_semester.probeklausur.coronawarnapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class CoronaWarn {

	/**
	 * Application entry point for CoronaWarn
	 *
	 * @param args command line arguments, not used here
	 */
	public static void main(String[] args) {
		try {
			// Only necessary on MacOS to prevent color issues with standard look and feel.
			// Redundant on other operation systems - they use this look and feel by
			// default.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (final Exception e) {
		}

		JPhone phone1 = new JPhone("0123-4567", "Markus");
		JPhone phone2 = new JPhone("9876-5432", "Angela");
		JPhone phone3 = new JPhone("4711-0815", "Olaf");

		CoronaWarnTerm client1 = new CoronaWarnTerm(phone1);
		CoronaWarnTerm client2 = new CoronaWarnTerm(phone2);
		CoronaWarnTerm client3 = new CoronaWarnTerm(phone3);

		CoronaWarnAPI.registerClients(client1, client2, client3);
	}

	/**
	 * Clear token store for phone
	 *
	 * @param phone phone to clear store for
	 */
	public static void clearTokenStore(JPhone phone) {
		// ADD CODE HERE
		System.out.println("Clear token store");
		Path p = Paths.get("C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\coronaWarn");
		try {
			Files.delete(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load tokens for phone
	 *
	 * @param phone phone to load tokens for
	 *
	 * @return loaded tokens
	 */
	public static List<Token> loadTokens(JPhone phone) {
		List<Token> tokens = new LinkedList<>();

		// REPLACE THE FOLLOWING CODE
		Path p = Paths.get(String.format(
				"C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\coronaWarn\\%s-tokens.txt",
				phone.getId()));
		try {
			Files.readAllLines(p).stream().map(l -> parseToken(l)).forEach(token -> tokens.add(token));;
		} catch(IOException e) {
			e.printStackTrace();
		}
		// END OF CODE TO REPLACE

		return tokens;
	}

	/**
	 * Save token for provided phone
	 *
	 * @param phone phone to save token for
	 * @param token token to save
	 */
	public static void saveToken(JPhone phone, Token token) {
		String line = token.getValue() + ";" + token.getDate().getTime();
		Path p = Paths.get(String.format(
				"C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\coronaWarn\\%s-tokens.txt",
				phone.getId()));
		if (Files.exists(p, LinkOption.NOFOLLOW_LINKS)) {
			try (BufferedWriter writer = Files.newBufferedWriter(p, StandardCharsets.UTF_8)) {
				writer.append(line);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			try (BufferedWriter writer = Files.newBufferedWriter(p, StandardCharsets.UTF_8)) {
				 File f = new File(String.format(
						"C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\coronaWarn\\%s-tokens.txt",
						phone.getId()));
				 boolean isCreated = f.createNewFile();
				if (!isCreated) {
					JOptionPane.showMessageDialog(null, "File could not be created!", "Error!",
							JOptionPane.ERROR_MESSAGE);
				}
				writer.append(line);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
		// ADD CODE HERE
	}

	/**
	 * Parse a token line
	 *
	 * @param line token line to parse
	 *
	 * @return parsed token instance
	 */
	private static Token parseToken(String line) {
		String[] parts = line.split("[;]");
		if (parts.length == 2) {
			try {
				return new Token(parts[0], new Date(Long.parseLong(parts[1])));
			} catch (Exception e) {
				System.err.println("Error parsing token line: " + line);
				e.printStackTrace();
			}
		}
		return null;
	}
}
