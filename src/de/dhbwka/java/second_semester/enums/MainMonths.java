package de.dhbwka.java.second_semester.enums;

import java.util.Calendar;

public class MainMonths {

	public static void main(String[] args) {
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		switch (currentMonth) {
		case 0:
			System.out.println(Months.JANUAR);
			break;
		case 1:
			System.out.println(Months.FEBRUAR);
			break;
		case 2:
			System.out.println(Months.MAERZ);
			break;
		case 3:
			System.out.println(Months.APRIL);
			break;
		case 4:
			System.out.println(Months.MAI);
			break;
		case 5:
			System.out.println(Months.JUNI);
			break;
		case 6:
			System.out.println(Months.JULI);
			break;
		case 7:
			System.out.println(Months.AUGUST);
			break;
		case 8:
			System.out.println(Months.SEPTEMBER);
			break;
		case 9:
			System.out.println(Months.OKTOBER);
			break;
		case 10:
			System.out.println(Months.NOVEMBER);
			break;
		case 11:
			System.out.println(Months.DEZEMBER);
			break;
		default:
			System.out.println("This month does not exist!!!");
		}
	}

}
