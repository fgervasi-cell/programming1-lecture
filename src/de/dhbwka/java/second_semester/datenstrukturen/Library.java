package de.dhbwka.java.second_semester.datenstrukturen;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Library {
	private static final String FILE_LOCATION = "C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\library.txt";
	private final JFrame frame;
	private final JTextField titleTextField;
	private final JTextField authorTextField;
	private final JTextField yearTextField;
	private final JTextField publisherTextField;
	private final JButton saveEntryButton;
	private Set<Book> books = new HashSet<>();
	private List<Book> sortList;
	private final File file;
	private final ActionListener saveAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!titleTextField.getText().isBlank() && !authorTextField.getText().isBlank()
					&& !yearTextField.getText().isBlank() && !publisherTextField.getText().isBlank()) {
				try {
					books.add(new Book(titleTextField.getText(), authorTextField.getText(),
							Integer.parseInt(yearTextField.getText()), publisherTextField.getText()));
					writeToFile(e.getSource());
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Please enter valid information!",
							"The information is no correct", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "You need to fill all fields!", "One or more fields are empty",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	private final ActionListener orderAction = new ActionListener() {
		private String getOrderedFile() {
			try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
				StringBuilder builder = new StringBuilder();
				while(reader.ready()) {
					builder.append(reader.readLine()+System.lineSeparator());
				}
				return builder.toString();
			} catch(IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "IOException occured!!!",
						JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			sortList = new ArrayList<>(books);
			JButton buttonClicked = (JButton) e.getSource();
			if ("Author".equals(buttonClicked.getText())) {
				Collections.sort(sortList, Book.COMPARE_AUTHOR);
			} else if ("Title".equals(buttonClicked.getText())) {
				Collections.sort(sortList, Book.COMPARE_TITLE);
			} else if ("Year".equals(buttonClicked.getText())) {
				Collections.sort(sortList, Book.COMPARE_YEAR);
			} else {
				Collections.sort(sortList, Book.COMPARE_PUBLISHER);
			}
			writeToFile(e.getSource());
			JOptionPane.showMessageDialog(null, getOrderedFile(), String.format("Books ordered by %s", buttonClicked.getText()),
					JOptionPane.INFORMATION_MESSAGE);
		}
	};

	public Library() {
		// create the file object and read the book file
		file = new File(FILE_LOCATION);
		readFile();

		// initialize required components
		frame = new JFrame();
		final JPanel top = new JPanel();
		final JPanel mid = new JPanel();
		final JPanel bottom = new JPanel();
		final JLabel title = new JLabel("Title");
		final JLabel author = new JLabel("Author");
		final JLabel year = new JLabel("Year");
		final JLabel publisher = new JLabel("Publisher");
		final JLabel order = new JLabel("Ordered output:");
		titleTextField = new JTextField();
		authorTextField = new JTextField();
		yearTextField = new JTextField();
		publisherTextField = new JTextField();
		saveEntryButton = new JButton("Save entry");
		final JButton titleButton = new JButton("Title");
		final JButton authorButton = new JButton("Author");
		final JButton yearButton = new JButton("Year");
		final JButton publisherButton = new JButton("Publisher");

		// add event listeners
		saveEntryButton.addActionListener(saveAction);
		titleButton.addActionListener(orderAction);
		authorButton.addActionListener(orderAction);
		yearButton.addActionListener(orderAction);
		publisherButton.addActionListener(orderAction);

		// set layouts
		frame.setLayout(new BorderLayout(5, 5));
		top.setLayout(new GridLayout(4, 2, 2, 2));
		bottom.setLayout(new FlowLayout());

		// add components to the top panel
		top.add(author);
		top.add(authorTextField);
		top.add(title);
		top.add(titleTextField);
		top.add(year);
		top.add(yearTextField);
		top.add(publisher);
		top.add(publisherTextField);

		// add components to the mid panel
		mid.add(saveEntryButton);

		// add components to the bottom panel
		bottom.add(order);
		bottom.add(authorButton);
		bottom.add(titleButton);
		bottom.add(yearButton);
		bottom.add(publisherButton);

		// add components to the frame
		frame.add(top, BorderLayout.NORTH);
		frame.add(mid, BorderLayout.CENTER);
		frame.add(bottom, BorderLayout.SOUTH);

		// configure the frame
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500, 250);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Library");
	}

	public void start() {
		frame.setVisible(true);
	}
	
	private void writeToFile(Object o) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			if(o.equals(saveEntryButton)) {
				for(Book book : books) {
					writer.append(String.format("%s;%s;%d;%s%s", book.getTitle(), book.getAuthor(), book.getYear(),
							book.getPublisher(), System.lineSeparator()));
				}
			} else {
				for(Book book : sortList) {
					writer.append(String.format("%s;%s;%d;%s%s", book.getTitle(), book.getAuthor(), book.getYear(),
							book.getPublisher(), System.lineSeparator()));
				}
			}
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "IOException occured!!!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void readFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while (reader.ready()) {
				String[] split = reader.readLine().split(";");
				books.add(new Book(split[0], split[1], Integer.parseInt(split[2]), split[3]));
			}
		} catch (IOException exception) {
			JOptionPane.showMessageDialog(null, exception.getMessage(), "IOException occured!!!",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
