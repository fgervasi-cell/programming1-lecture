package de.dhbwka.java.second_semester.enums.library_enums;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Library {
	private JFrame frame;
	private String filename = "C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\library_enums\\books.txt";
	private JTextField[] inputFields;
	private List<Book> books = new ArrayList<>();
	
	public Library() {
		this.loadBooks();
		JPanel panInput = new JPanel();
		panInput.setLayout(new GridLayout(4, 2, 5, 5));
		this.inputFields = new JTextField[Attributes.values().length];
		for(int i = 0; i < Attributes.values().length; i++) {
			panInput.add(new JLabel(Attributes.values()[i].name().charAt(0) + Attributes.values()[i].name().substring(1).toLowerCase()));
			this.inputFields[i] = new JTextField("");
			panInput.add(this.inputFields[i]);
		}
		JButton btnSave = new JButton("Save entry");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Library.this.saveBook(Library.this.inputFields[0].getText(), Library.this.inputFields[1].getText(), Integer.parseInt(Library.this.inputFields[2].getText()), Library.this.inputFields[3].getText());
				for(JTextField field : Library.this.inputFields) {
					field.setText("");
				}
			}
		});
		JPanel panSort = new JPanel(new FlowLayout());
		panSort.add(new JLabel("Ordered output:"));
		for(int i = 0; i < Attributes.values().length; i++) {
			JButton but = new JButton(Attributes.values()[i].name().charAt(0) + Attributes.values()[i].name().substring(1).toLowerCase());
			but.setActionCommand(Integer.toString(Attributes.values()[i].ordinal()));
			but.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Library.this.sort(Attributes.values()[Integer.parseInt(e.getActionCommand())]);
				}
			});
			panSort.add(but);
		}
		this.frame = new JFrame("Library");
		this.frame.setLayout(new BorderLayout());
		this.frame.add(panInput, BorderLayout.NORTH);
		this.frame.add(btnSave, BorderLayout.CENTER);
		this.frame.add(panSort, BorderLayout.SOUTH);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(500, 190);
		this.frame.setVisible(true);
	}
	
	public void saveBook(String title, String author, int year, String publisher) {
		Book book = new Book(title, author, year, publisher);
		this.books.add(book);
		try(PrintWriter pw = new PrintWriter(new FileWriter(new File(this.filename), true))) {
			pw.println(book);
		} catch(Exception ex) {
			System.err.println("Write error: " + ex.getLocalizedMessage());
		}
	}
	
	public void loadBooks() {
		try(BufferedReader br = new BufferedReader(new FileReader(new File(this.filename)))) {
			while(br.ready()) {
				String[] parts = br.readLine().split(";");
				if(parts.length == 4) {
					this.books.add(new Book(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
				}
			}
		} catch(Exception ex) {
			System.err.println("Read error: " + ex.getLocalizedMessage());
		}
	}
	
	public void sort(Attributes order) {
		Collections.sort(this.books, new BookComparator(order));
		JOptionPane.showMessageDialog(this.frame, this, "Books ordered by " + order.name().charAt(0) + order.name().substring(1).toLowerCase(), JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer("");
		for(Book book : this.books) {
			output.append(book + System.lineSeparator());
		}
		return output.toString();
	}
	
	public static void main(String[] args) {
		new Library();
	}
}
