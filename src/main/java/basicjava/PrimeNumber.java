package basicjava;
import java.util.*;
public class PrimeNumber {

	public static void main(String[] args) {
		// Get a input number and set the flag as 0
		int inputNbr = 0;
		primeNbr(inputNbr);
		
	}


	public static void primeNbr(int a)
	{
		int flag = 0;
		System.out.println("Enter a Number to check Prime Number or not = ");
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		if(a == 0 || a == 1)
			System.out.println("The numbers 0 and 1 are not prime numbers");
		else
		{
			for(int i = 2; i<=(a/2);i++)
			{ 

				if(a%i == 0)
					flag=1;
				break;

			}
			if(flag==0)
				System.out.println(a + " is a Prime Number");
			else
				System.out.println(a + " is not a Prime Number");
		}



	}


}
