package basicjava;

public class Construct {

	static int i;
	static String name;
	static float j;
	static Double k;
	
	Construct(int a, String b, float c, Double d)
	{
		i=a;
		name=b;
		j=c;
		k=d;
		
	}
	
	
	public static void main(String[] args) {

		Construct obj1 = new Construct(5, "Test", 8.5f, 20.5);
		
		System.out.println(obj1.i);
		System.out.println(obj1.name);
		System.out.println(obj1.j);
		System.out.println(obj1.k);

}
}

