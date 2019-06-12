package basicjava;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// Get the input
		System.out.println("Enter the number to validate is it a Palindrome or not:");
		Scanner scan = new Scanner(System.in);
		int inputNumber = scan.nextInt();
		scan.close();
		if(inputNumber<0)
		{
			inputNumber = inputNumber*-1;
		}
		int originalNumber = inputNumber;
		int reverseNumber = 0;
		//Reverse the Number
		while(inputNumber != 0)
		{

			int quotient = inputNumber/10;
			int reminder = inputNumber%10;
			reverseNumber = reverseNumber*10+reminder;
			inputNumber = quotient;
		}

		if(originalNumber ==reverseNumber)
		{
			System.out.println(originalNumber + " is a Palindrome");
		}
		else
		{
			System.out.println(originalNumber + " is not a Palindrome");

		}
	}




}


