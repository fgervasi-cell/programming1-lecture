package de.dhbwka.java.second_semester.datenstrukturen;

import java.util.Comparator;

public class Book {
	private String title;
	private String author;
	private int year;
	private String publisher;

	public Book(String title, String author, int year, String publisher) {
		this.setTitle(title);
		this.setAuthor(author);
		this.setYear(year);
		this.setPublisher(publisher);
	}
	
	public static final Comparator<Book> COMPARE_TITLE = new Comparator<Book>() {
		
		@Override
		public int compare(Book o1, Book o2) {
			return o1.getTitle().toLowerCase().charAt(0) >= o2.getTitle().toLowerCase().charAt(0) ? 1 : -1;
		}
	};
	
	public static final Comparator<Book> COMPARE_AUTHOR = new Comparator<Book>() {

		@Override
		public int compare(Book o1, Book o2) {
			return o1.getAuthor().toLowerCase().charAt(0) >= o2.getAuthor().toLowerCase().charAt(0) ? 1 : -1;
		}
	};
	
	public static final Comparator<Book> COMPARE_YEAR = new Comparator<Book>() {

		@Override
		public int compare(Book o1, Book o2) {
			return o1.getYear() <= o2.getYear() ? 1 : -1;
		}
	};
	
	public static final Comparator<Book> COMPARE_PUBLISHER = new Comparator<Book>() {

		@Override
		public int compare(Book o1, Book o2) {
			return o1.getPublisher().toLowerCase().charAt(0) >= o2.getPublisher().toLowerCase().charAt(0) ? 1 : -1;
		}
	};

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
