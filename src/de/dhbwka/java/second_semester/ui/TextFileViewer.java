package de.dhbwka.java.second_semester.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;

public class TextFileViewer {
	
	public void init() {
		JFrame frame = new JFrame();
		File file = getFile();
		if(file == null) {
			frame.dispose();
		} else {
			JTextArea textArea = new JTextArea();
			try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
				while(reader.ready()) {
					textArea.append(reader.readLine() + System.lineSeparator());
				}
				textArea.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(textArea);
				frame.setTitle(file.getName());
				frame.add(scrollPane);
				frame.setLocationRelativeTo(null);
				frame.setSize(500, 500);
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.setVisible(true);
			} catch(IOException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
				frame.dispose();
			}
		}
	}

	private File getFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().endsWith(".txt");
			}

			@Override
			public String getDescription() {
				return "Text Files";
			}
			
		});
		fileChooser.setAcceptAllFileFilterUsed(false);
		int state = fileChooser.showOpenDialog(null);
		if(state == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		} else {
			JOptionPane.showMessageDialog(null, "No file was chosen..." + System.lineSeparator() + "Exiting the application!", "No file", JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
	}
	
}
