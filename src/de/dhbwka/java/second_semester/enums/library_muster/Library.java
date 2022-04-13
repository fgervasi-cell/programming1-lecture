package de.dhbwka.java.second_semester.enums.library_muster;

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

@SuppressWarnings("all")
public class Library {
	private static final String[] orderCriteria = { "Title", "Author", "Year", "Publisher" };
	private JFrame frame;
	private String filename = "books.txt";
	private JTextField[] inputFields;
	private List<Book> books = new ArrayList<>();
	
	public Library() {
		this.loadBooks();
		JPanel panInput = new JPanel();
		panInput.setLayout(new GridLayout(4, 2, 5, 5));
		this.inputFields = new JTextField[Library.orderCriteria.length];
		for(int i = 0; i < Library.orderCriteria.length; i++) {
			panInput.add(new JLabel(Library.orderCriteria[i]));
			this.inputFields[i] = new JTextField("");
			panInput.add(this.inputFields[i]);
		}
		JButton btnSave = new JButton("Save entry");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Library.this.saveBook(Library.this.inputFields[0].getText(), Library.this.inputFields[1].getText(), new Integer(Library.this.inputFields[2].getText()), Library.this.inputFields[3].getText());
				for(JTextField field : Library.this.inputFields) {
					field.setText("");
				}
			}
		});
		JPanel panSort = new JPanel(new FlowLayout());
		panSort.add(new JLabel("Ordered output:"));
		for(int i = 0; i < Library.orderCriteria.length; i++) {
			JButton but = new JButton(Library.orderCriteria[i]);
			but.setActionCommand(Integer.toString(Book.CRITERIA[i]));
			but.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Library.this.sort(Integer.parseInt(e.getActionCommand()));
				}
			});
			panSort.add(but);
		}
		this.frame = new JFrame("Library");
		this.frame.setLayout(new BorderLayout());
		this.frame.add(panInput, BorderLayout.NORTH);
		this.frame.add(btnSave, BorderLayout.CENTER);
		this.frame.add(panInput, BorderLayout.SOUTH);
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
					this.books.add(new Book(parts[0], parts[1], new Integer(parts[2]), parts[3]));
				}
			}
		} catch(Exception ex) {
			System.err.println("Read error: " + ex.getLocalizedMessage());
		}
	}
	
	public void sort(int order) {
		Collections.sort(this.books, new BookComparator(order));
		JOptionPane.showMessageDialog(this.frame, this, "Books ordered by " + Library.orderCriteria[order], JOptionPane.INFORMATION_MESSAGE);
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
