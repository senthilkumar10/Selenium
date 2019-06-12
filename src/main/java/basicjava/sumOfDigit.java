package basicjava;

import java.util.Scanner;

public class sumOfDigit {

	public static void main(String[] args) {
		// Get the input
		System.out.println("Enter the numbers that should be summed :-");
		Scanner scan = new Scanner(System.in);
		int inputNumber = scan.nextInt();

		//Split the number and sum it

		int sumOfDigit=0;

		while(inputNumber != 0)
		{
			int quotient = inputNumber /10;
			int reminder = inputNumber %10;
			sumOfDigit = sumOfDigit+reminder;
			inputNumber = quotient;	
		}

		//Print the Sum of Digits
		
		System.out.println("The Sum of the digits given = " +sumOfDigit);



	}

}
