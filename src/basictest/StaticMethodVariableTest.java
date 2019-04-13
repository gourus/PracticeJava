package basictest;

public class StaticMethodVariableTest {
	
	public int nbk;
	
	static {
		System.out.println("Static Block Executed...");
	}
	
	// Instance Block
	{
		nbk++;
		System.out.println(nbk);
		System.out.println("Instance Block Executed...");
	}
	
	public StaticMethodVariableTest() {
		nbk=100;
		System.out.println("Default constructor executed...");
	}
	
	public void sum(Integer a,Integer b)
	{
		System.out.println("Integer Object sum called.. : "+(a+b));
	}
	
	public void sum(int a,int b)
	{
		System.out.println("primitive sum called... : "+(a+b));
	}
	
	public void sum(Number a, Number b)
	{
		System.out.println("Number Object sum called.. : ");
	}
	

	// public int nbk; // If we define nbk here, we will get Illegal forward reference error in instance block
	public int i = 0;
	public int j = 0;
	
	public static int n = 0;
	
	public static void main(String[] args)
	{
		//j = 0; // Compile time error Cannot make a static reference to the non-static field i
		
		StaticMethodVariableTest staticMethodVariableTest = new StaticMethodVariableTest();
		
		int a = 10;
		int b = 20;
		
		// Primitive will get the priority if we pass direct values to function
		staticMethodVariableTest.sum(a, b); // Primitive sum
		staticMethodVariableTest.sum(11,22); // primitive sum
		staticMethodVariableTest.sum(Integer.valueOf(5), Integer.valueOf(10)); // Integer Object sum
		staticMethodVariableTest.sum(11.0,22.0); // Number Object sum
		
	}
	
	public static int getI()
	{
		//return i; // Compile time error : Cannot make a static reference to the non-static field i
		return n;
	}
	

}
