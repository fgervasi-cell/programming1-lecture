package de.dhbwka.java.exercise.classes.point;

public class Point {
	private double xCoordinate;
	private double yCoordinate;

	Point() {
		setxCoordinate(0.0);
		setyCoordinate(0.0);
	}

	Point(double xCoordinate, double yCoordinate) {
		this.setxCoordinate(xCoordinate);
		this.setyCoordinate(yCoordinate);
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	@Override
	public String toString() {
		return "X-Koordinate: " + xCoordinate + "; Y-Koordinate: " + yCoordinate;
	}

	public double getDistanceToOrigin() {
		return Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2));
	}
	
	public void reflectXAxis() {
		yCoordinate *= -1;
	}
	
	public void reflectYAxis() {
		xCoordinate *= -1;
	}
	
	public void reflectOrigin() {
		xCoordinate *= -1;
		yCoordinate *= -1;
	}
	
	public double distanceBetweenPoints(Point point) {
		return Math.sqrt(Math.pow(xCoordinate - point.getxCoordinate(), 2) + Math.pow(yCoordinate - point.getyCoordinate(), 2));
	}
}
