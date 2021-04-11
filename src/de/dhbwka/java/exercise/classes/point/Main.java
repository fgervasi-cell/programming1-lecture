package de.dhbwka.java.exercise.classes.point;

public class Main {

	public static void main(String[] args) {
		Point pointA = new Point(4.0, 2.0);
		System.out.println("A: " + pointA);
		Point pointB = new Point(-1.0, -1.0);
		System.out.println("B: " + pointB);
		System.out.println("Abstand A-B: " + pointA.distanceBetweenPoints(pointB));
		pointA.reflectOrigin();
		System.out.println("A reflected: " + pointA);
		System.out.println("Abstand A reflected-B: " + pointA.distanceBetweenPoints(pointB));
	}

}
