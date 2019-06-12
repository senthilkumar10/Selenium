package basicjava;

public class StringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "TestLeaf Java";
		String str2 = "TestLeaf Java";
		String str3 = new String("TestLeaf Java");
		String str4 = new String("testLeaf Java");
		String str5 = new String("Java");
		
		compareStrings(str1,str2,str3,str4,str5);

	}

	public static void compareStrings(String s1,String s2,String s3,String s4,String s5)
	{

		if (s1==s2)
			System.out.println("String 1 and String 2 are the same");
		
		else
			System.out.println("String 1 and String 2 are not the same");	
		
	
		if (s1.equals(s2))
			System.out.println("String 1 and String 2 are the same");
		
		else
			System.out.println("String 1 and String 2 are not the same");	
		
		if (s1.equals(s3))
			System.out.println("String 1 and String 3 are the same");
		
		else
			System.out.println("String 1 and String 3 are not the same");	
	
		if (s1.equalsIgnoreCase(s4))
			System.out.println("String 1 and String 4 are the same");
		
		else
			System.out.println("String 1 and String 4 are not the same");	
	
		if (s3.contains(s5))
			System.out.println("String 3 contains String 5");
		
		else
			System.out.println("String 3 does not contains String 5");	
		
			
	}



}
