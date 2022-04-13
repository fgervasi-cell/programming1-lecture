package de.dhbwka.java.second_semester.enums.library_enums;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
	private Attributes order;
	
	public BookComparator(Attributes order) {
		this.order = order;
	}

	@Override
	public int compare(Book b1, Book b2) {
		switch(this.order.name()) {
		case "TITLE":
			return b1.getTitle().compareTo(b2.getTitle());
		case "AUTHOR":
			return b1.getAuthor().compareTo(b2.getAuthor());
		case "YEAR":
			return b1.getYear() - b2.getYear();
		case "PUBLISHER":
			return b1.getPublisher().compareTo(b2.getPublisher());
		}
		return 0;
	}
}
