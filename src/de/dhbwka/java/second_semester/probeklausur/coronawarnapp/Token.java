package de.dhbwka.java.second_semester.probeklausur.coronawarnapp;

import java.util.Date;
import java.util.UUID;

public class Token {
	private String value;
	private Date date;

	public Token() {
		this.setValue(UUID.randomUUID().toString());
		this.setDate(new Date());
	}

	public Token(String value, Date date) {
		this.setValue(value);
		this.setDate(date);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return String.format("%s @ %s", this.value, this.date.toGMTString());
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
