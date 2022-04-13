package de.dhbwka.java.second_semester.events;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ShellGame {

	private final File file;
	private final JFrame frame;
	private final JButton statisticsButton;
	private JButton exitButton;
	private JButton shell1;
	private JButton shell2;
	private JButton shell3;
	private JTextField outputTextField;
	private JTextField playerNameTextField;
	private int correctGuesses = 0;
	private int shellIndicator;
	private int attempts = 0;
	private final Random rnd;

	//Create listener for shell buttons
	private ActionListener shellListener = new ActionListener() {
		
		private void writeToFile(String shellNumber) {
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
				System.out.println("Correct guesses: " + correctGuesses);
				if(correctGuesses > 1) {
					writer.newLine();
				}
				writer.append(String.format("%s found the ball after %d attempts below shell %s", playerNameTextField.getText(), attempts, shellNumber));
			} catch(IOException exception) {
				System.out.println("Oh no!!!");
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!playerNameTextField.getText().isBlank()) {
				//Increment attempts
				attempts++;
				//Check which button was clicked
				if(e.getSource().equals(shell1) && shellIndicator == 1) {
					outputTextField.setText(String.format("Attempt %d wins: Ball was below shell 1", attempts));
					correctGuesses++;
					writeToFile("1");
					attempts = 0;
				} else if(e.getSource().equals(shell2) && shellIndicator == 2) {
					outputTextField.setText(String.format("Attempt %d wins: Ball was below shell 2", attempts));
					correctGuesses++;
					writeToFile("2");
					attempts = 0;
				} else if(e.getSource().equals(shell3) && shellIndicator == 3) {
					outputTextField.setText(String.format("Attempt %d wins: Ball was below shell 3", attempts));
					correctGuesses++;
					writeToFile("3");
					attempts = 0;
				} else {
					outputTextField.setText(String.format("Attempt: %d. The ball was not under there. Try again!", attempts));
				}
				shellIndicator = rnd.nextInt(2) + 1;
				System.out.println(shellIndicator);
			} else {
				JOptionPane.showMessageDialog(frame, "You need to enter your name!!!", "No name", JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	public ShellGame(String filePath) {
		//Create the file for the statistics
		file = new File(filePath);
		
		//Generate random shellIndicator
		rnd = new Random();
		shellIndicator = rnd.nextInt(2) + 1;
		System.out.println(shellIndicator);
		
		// Initialize all needed Components
		frame = new JFrame();
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JLabel playerName = new JLabel("Player Name");
		shell1 = new JButton("Shell 1");
		shell2 = new JButton("Shell 2");
		shell3 = new JButton("Shell 3");
		statisticsButton = new JButton("Statistics");
		exitButton = new JButton("Exit");
		playerNameTextField = new JTextField();
		outputTextField = new JTextField();
		
		//Set action commands
		shell1.setActionCommand("1");
		shell2.setActionCommand("2");
		shell3.setActionCommand("3");

		// Configure components
		outputTextField.setEditable(false);

		// Configure layouts
		mainPanel.setLayout(new BorderLayout());
		GridLayout northPanelLayout = new GridLayout(0, 2);
		northPanel.setLayout(northPanelLayout);
		centerPanel.setLayout(new FlowLayout());

		// Add components to the northern panel
		northPanel.add(playerName);
		northPanel.add(playerNameTextField);

		// Add components to the centered panel
		centerPanel.add(shell1);
		centerPanel.add(shell2);
		centerPanel.add(shell3);
		centerPanel.add(statisticsButton);
		centerPanel.add(exitButton);

		// Add components to the main panel
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(outputTextField, BorderLayout.SOUTH);

		// Add the necessary EventListeners
		addEventListeners();

		// Configure the frame
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Shell Game");
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 500);
		frame.add(mainPanel);
	}

	// Make frame visible
	public void start() {
		frame.setVisible(true);
	}

	private void addEventListeners() {
		shell1.addActionListener(shellListener);
		shell2.addActionListener(shellListener);
		shell3.addActionListener(shellListener);
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		statisticsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
					double playerWins = 0.0;
					int playerAttemptsTotal = 0;
					while(reader.ready()) {
						String line = reader.readLine();
						if(line.startsWith(playerNameTextField.getText())) {
							playerWins++;
							playerAttemptsTotal += Double.parseDouble(Character.toString(line.charAt(27)));
						}
					}
					outputTextField.setText(playerWins != 0 ? String.format("Success after %f attempts!!?", (playerAttemptsTotal/playerWins)) : "No wins!!!");
				} catch(IOException exception) {
					System.out.println("Some Error!!!");
				}
			}
		});
	}
}
