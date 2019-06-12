package basicjava;

import java.util.*;

public class DayOfTheWeek {

	public static void main(String[] args) {
		// Get the input
		System.out.println("Enter a Week day = ");
		Scanner scan = new Scanner(System.in);
		String day = scan.next();
		String lowercase = day.toLowerCase();
		switch(lowercase){
		case("sunday"):System.out.println(day + " is the 1st day of the week");break;
		case("monday"):System.out.println(day + " is the 2nd day of the week");break;
		case("tuesday"):System.out.println(day + " is the 3rd day of the week");break;
		case("wednesday"):System.out.println(day + " is the 4th day of the week");break;
		case("thursday"):System.out.println(day + " is the 5th day of the week");break;
		case("friday"):System.out.println(day + " is the 6th day of the week");break;
		case("saturday"):System.out.println(day + " is the 7th day of the week");break;
		default:System.out.println(day + " is an invalid input");break;
		}
		
	}
		

}
