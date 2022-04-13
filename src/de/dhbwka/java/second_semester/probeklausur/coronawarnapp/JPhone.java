package de.dhbwka.java.second_semester.probeklausur.coronawarnapp;

public class JPhone {
	private String id;
	private String owner;
	
	public JPhone(String id, String owner) {
		this.setId(id);
		this.setOwner(owner);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
