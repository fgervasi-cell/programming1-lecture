package de.dhbwka.java.second_semester.java8;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("all")
public class NumberGuess8 extends JFrame {
	private static final long serialVersionUID = -840334684557875194L;
	private int numberToGuess;
	private int countAttempts;
	private int limit = 1000;
	private JButton btnExit = new JButton("Exit");
	private JButton btnOk = new JButton("OK");
	private JButton btnNew = new JButton("New Game");
	private JButton btnStat = new JButton("Best Player");
	private JTextField txtName = new JTextField("Name", 20);
	private JTextField txtGuess = new JTextField(10);
	private JTextField txtOutput = new JTextField(40);
	private String statFileName = "C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\number_guess\\stat.txt";

	public NumberGuess8() {
		super("Number Guessing Game");
		List<JButton> buttons = Arrays.asList(btnNew, btnOk, btnStat, btnExit);
		JPanel panName = new JPanel();
		JPanel panNumberinput = new JPanel();
		JPanel panButtons = new JPanel();
		JPanel panOutput = new JPanel();
		List<JPanel> panels = Arrays.asList(panName, panNumberinput, panButtons, panOutput);
		panName.add(new JLabel("Player Name"));
		panName.add(this.txtName);
		panNumberinput.add(new JLabel("Enter number beween 1 and " + this.limit));
		panNumberinput.add(this.txtGuess);
		buttons.forEach(panButtons::add);
		panOutput.add(this.txtOutput);
		this.setLayout(new GridLayout(4, 1));
		panels.forEach(this::add);
		this.addEventHandling();
		this.createRandomNumber();
		this.setSize(500, 250);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addEventHandling() {
		this.btnNew.addActionListener(event -> NumberGuess8.this.createRandomNumber());
		this.btnExit.addActionListener(event -> System.exit(0));
		ActionListener okListener = NumberGuess8.this::okActionListener;
		this.txtGuess.addActionListener(okListener);
		this.btnOk.addActionListener(okListener);
		this.btnStat.addActionListener(event -> NumberGuess8.this.showBestPlayer());
	}

	public void okActionListener(ActionEvent event) {
		try {
			int guess = Integer.parseInt(this.txtGuess.getText());
			this.countAttempts++;
			this.txtGuess.setText("");
			if (guess > this.numberToGuess) {
				this.txtOutput.setText(String.format("Attempt #%s: %s => too big!", this.countAttempts, guess));
			} else if (guess < this.numberToGuess) {
				this.txtOutput.setText(String.format("Attempt #%s: %s => too small!", this.countAttempts, guess));
			} else {
				this.txtOutput
						.setText(String.format("Attempt #%s: %s => correct!!! New Game!", this.countAttempts, guess));
				this.writeStatFile();
				this.createRandomNumber();
			}
		} catch (NumberFormatException nfe) {
			this.txtOutput.setText("Bad input!");
		}
	}

	private void writeStatFile() {
		try (FileWriter f = new FileWriter(this.statFileName, true)) {
			String name = this.txtName.getText();
			f.write(name + " " + this.countAttempts + " attempts\n");
		} catch (Exception e) {
		}
	}

	private void showBestPlayer() {
		try {
			List<String> lines = Files.readAllLines(Paths.get(statFileName));
			OptionalInt minAttempts = lines.stream().map(l -> l.split(" ")[1]).mapToInt(Integer::parseInt).min();
			Stream<String> linesMatching = lines.stream()
					.filter(l -> Integer.parseInt(l.split(" ")[1]) == minAttempts.getAsInt());
			List<String> name = linesMatching.collect(Collectors.toList());
			this.txtOutput.setText("Best Player: " + name.get(0) + ", " + minAttempts.getAsInt() + " attempts");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void createRandomNumber() {
		this.txtGuess.setText("");
		this.txtOutput.setText("New Game!");
		this.numberToGuess = (int) (Math.random() * this.limit + 1);
		this.countAttempts = 0;
		// For debugging purposes
		System.out.println("Number to guess: " + this.numberToGuess);
	}

	public static void main(String args[]) {
		new NumberGuess8();
	}

}
