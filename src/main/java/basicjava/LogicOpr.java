package basicjava;

public class LogicOpr {

	public static void main(String[] args) {

		int num1=5;
		int num2=3;
		boolean flag = true;

		if(!flag)
			System.out.println(flag);

		if(num1==5 && num2++==3)
			System.out.println("Number 1 = " + num1);
			System.out.println("Number 2 = " + num2);

		if(num1==5 || ++num2==5)
			System.out.println();
		
		if(--num2==3&&num1++==5)
			System.out.println();
		
		if(num2--==4 || ++num1==7)
			System.out.println();

	}


}
