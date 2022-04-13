package de.dhbwka.java.second_semester.events;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class NumberGuess {
	private static int guessingNumber = (int)(Math.random()*1000);
	private static int counter = 0;
	private static File f = new File("C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\best-players.txt");
	
	private NumberGuess() {
		
	}
	
	public static void open() {
		JFrame frame = new JFrame();
		JPanel mainPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel playerNamePanel = new JPanel();
		JPanel numberPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		JLabel playerNameLabel = new JLabel("Player Name");
		JLabel numberLabel = new JLabel("Enter a number between 1 and 1000");
		JTextField playerNameTextField = new JTextField();
		JTextField numberTextField = new JTextField();
		JTextField resultTextField = new JTextField();
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guessingNumber = (int)(Math.random()*1000);
				counter = 0;
			}
		});
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!playerNameTextField.getText().isEmpty()) {
					if(Integer.parseInt(numberTextField.getText()) == guessingNumber) {
						resultTextField.setText("Guess " + ++counter + " .You guessed it right! The number was " + guessingNumber);	
						try(BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
							boolean lineIsEmpty = true;
							List<String> lines = new ArrayList<>();
							String overrideLine = "";
							LineNumberReader reader = new LineNumberReader(new FileReader(f));
							int lineNumber = 0;
							while(reader.ready()) {
								overrideLine = reader.readLine();
								lines.add(overrideLine);
								if(overrideLine.contains(playerNameTextField.getText())) {
									lineIsEmpty = false;
									lineNumber = reader.getLineNumber();
								}
							}
							if(!lineIsEmpty) {
								writer.append(String.format("Player: %s; Score: %s" + System.lineSeparator(), playerNameTextField.getText(), counter));
							} else {
								File tempFile = new File("C:\\\\Users\\\\fgerv\\\\eclipse-workspace\\\\University\\\\FileExperimentsFolder\\\\best-players-temp.txt");
								int index = 0;
								for(String line : lines) {
									if(index++ != lineNumber) {
										writer.append(line + System.lineSeparator());
									} else {
										writer.append( String.format("Player: %s; Score: %s" + System.lineSeparator(), playerNameTextField.getText(), counter));
									}
								}
								reader.close();
								f = tempFile;
								tempFile.delete();
							}
						} catch(IOException exception) {
							resultTextField.setText("File not found!!!");
						}
					} else {
						if(Integer.parseInt(numberTextField.getText()) < guessingNumber) {
							resultTextField.setText("Guess " + ++counter + " .Your number is too small!");
						} else {
							resultTextField.setText("Guess " + ++counter + " .Your number is too big!");
						}
					}
				} else {
					resultTextField.setText("You need to enter a name!!!");
				}
			}
		});
		JButton bestPlayerButton = new JButton("Best Player");
		bestPlayerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try(LineNumberReader reader = new LineNumberReader(new FileReader(f))) {
					reader.mark(1000);
					String bestPlayer = "";
					List<Integer> scores = new ArrayList<>();
					while(reader.ready()) {
						String line = reader.readLine();
						String[] split = line.split(" ");
						scores.add(Integer.parseInt(split[3]));
					}
					reader.reset();
					while(reader.ready()) {
						String line = reader.readLine();
						if(scores.indexOf(Collections.min(scores)) + 1 == reader.getLineNumber()) {
							bestPlayer = line;
							break;
						}
					}
					resultTextField.setText(bestPlayer);
				} catch(IOException exception) {
					resultTextField.setText("An IOException occured!!!");
				}
			}
		});
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mainPanel.setLayout(new BorderLayout());
		playerNameTextField.setColumns(15);
		playerNamePanel.add(playerNameLabel);
		playerNamePanel.add(playerNameTextField);
		topPanel.add(playerNamePanel, BorderLayout.NORTH);
		numberTextField.setColumns(15);
		numberPanel.add(numberLabel);
		numberPanel.add(numberTextField);
		topPanel.add(numberPanel, BorderLayout.CENTER);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		buttonPanel.add(newGameButton);
		buttonPanel.add(okButton);
		buttonPanel.add(bestPlayerButton);
		buttonPanel.add(exitButton);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		resultTextField.setEditable(false);
		mainPanel.add(resultTextField, BorderLayout.SOUTH);
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Number Guessing Game");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setSize(500, 180);
		frame.setVisible(true);
	}
}
