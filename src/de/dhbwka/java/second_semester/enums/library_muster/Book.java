package de.dhbwka.java.second_semester.enums.library_muster;

public class Book {
	public static final int TITLE = 0;
	public static final int AUTHOR = 1;
	public static final int YEAR = 2;
	public static final int PUBLISHER = 3;
	public static final int[] CRITERIA = { Book.TITLE, Book.AUTHOR, Book.YEAR, Book.PUBLISHER };
	private String title;
	private String author;
	private int year;
	private String publisher;

	public Book() {

	}

	public Book(String title, String author, int year, String publisher) {
		super();
		this.setTitle(title);
		this.setAuthor(author);
		this.setYear(year);
		this.setPublisher(publisher);
	}

	@Override
	public String toString() {
		return this.getTitle() + ";" + this.getAuthor() + ";" + this.getYear() + ";" + this.getPublisher();
	}

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
