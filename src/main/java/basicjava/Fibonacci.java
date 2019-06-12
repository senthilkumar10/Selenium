package basicjava;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 0;
		int j = 1;
		int k = 0;
		System.out.print(i+" ");
		while(k <100)
		{
			k=i+j;
			if(k<=100)
			{
			System.out.print(k+" ");
			}
			j=i;
			i=k;
			
					
		}

	}

}
