package basicjava;

import java.util.*;

public class MultiplicationTable {

	public static void main(String[] args) {
		// Get the Input
		System.out.println("Enter a number to print Muliplication table");
		Scanner scan = new Scanner(System.in);
		int inputNumber = scan.nextInt();
		for(int i=1;i<=10;i++)
		{
			System.out.println(inputNumber+" X " +i+" = "+inputNumber*i);
		}

	}

}
