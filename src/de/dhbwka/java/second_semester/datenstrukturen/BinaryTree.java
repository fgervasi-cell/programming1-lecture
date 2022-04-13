package de.dhbwka.java.second_semester.datenstrukturen;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
	private T value;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	private List<T> sortedValues;

	public boolean add(T newValue) {
		if (this.isEmpty()) {
			this.value = newValue;
			this.right = new BinaryTree<>();
			this.left = new BinaryTree<>();
			return true;
		} else if (this.value.compareTo(newValue) > 0) {
			this.left.add(newValue);
		} else if (this.value.compareTo(newValue) < 0) {
			this.right.add(newValue);
		}
		return false;
	}

	public T getValue() {
		return this.value;
	}

	public List<T> traverse() {
		sortedValues = new ArrayList<>();
		walkTree(this);
		for(int i = 0; i < sortedValues.size(); i++) {
			if(sortedValues.get(i) == null) {
				sortedValues.remove(i);
			}
		}
		return sortedValues;
	}
	
	private void walkTree(BinaryTree<T> node) {
		if(node.left != null) {
			walkTree(node.left);
		}
		sortedValues.add(node.getValue());
		if(node.right != null) {
			walkTree(node.right);
		}
	}

	public boolean isEmpty() {
		return this.value == null;
	}
}
