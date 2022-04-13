package de.dhbwka.java.second_semester.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TextFrame extends JFrame {

	private static final long serialVersionUID = 8483623301100708796L;

	public TextFrame(String filePath, String width, String height) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.black);
		mainPanel.setBorder(border);
		this.add(mainPanel);
		JTextArea textArea = new JTextArea();
		File file = new File(filePath);
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while (reader.ready()) {
				textArea.append(reader.readLine() + System.lineSeparator());
			}
		} catch (IOException e) {
			this.setSize(500, 500);
			JOptionPane.showMessageDialog(mainPanel,
					"There was an IOException!" + System.lineSeparator() + "Could not find the specified file!",
					"Exception", JOptionPane.ERROR_MESSAGE);
		}
		textArea.setEditable(false);
		mainPanel.add(textArea);
		this.setTitle(file.getName());
		try {
			this.setSize(Integer.parseInt(width), Integer.parseInt(height));
		} catch (NumberFormatException e) {
			this.setSize(500, 500);
			JOptionPane.showMessageDialog(mainPanel, "There was a NumberFormatException!" + System.lineSeparator()
			+ "Using default height and width (500 pixels)...", "Exception", JOptionPane.ERROR_MESSAGE);
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
