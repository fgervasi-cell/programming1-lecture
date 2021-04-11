package de.dhbwka.java.exercise.classes.periodic;

public class PeriodicTable {
	private Element[] elements;
	private int savedElements;

	public PeriodicTable() {
		savedElements = 0;
		elements = new Element[118];
	}

	public void addElement(Element e) {
		if (!hasElement(e.getOrdinal())) {
			savedElements++;
			for (int i = 0; i < elements.length; i++) {
				if (elements[i] == null) {
					elements[i] = e;
					break;
				}
			}
		}
	}

	public boolean hasElement(int o) {
		for (Element e : elements) {
			if (e != null) {
				if (e.getOrdinal() == o) {
					return true;
				}
			}
		}
		return false;
	}

	public Element getElement(int o) {
		for (Element e : elements) {
			if (e != null) {
				if (e.getOrdinal() == o) {
					return e;
				}
			}
		}
		return null;
	}
	
	public Element[] getElements() {
		Element[] temp = new Element[savedElements];
		System.arraycopy(this.elements, 0, temp, 0, savedElements);
		return temp;
	}

	public Element[] getMetals() {
		Element[] temp = new Element[savedElements];
		int numberOfMetals = 0;
		for (int i = 0; i < temp.length; i++) {
			if (elements[i] instanceof Metal) {
				for (int j = 0; j < temp.length; j++) {
					if (temp[j] == null) {
						numberOfMetals++;
						temp[j] = elements[i];
						break;
					}
				}
			}
		}
		Element[] metals = new Element[numberOfMetals];
		System.arraycopy(temp, 0, metals, 0, numberOfMetals);
		return metals;
	}
}
