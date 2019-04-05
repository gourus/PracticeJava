package basictest;

public class StaticMethodVariableTest {
	
	
	public int i = 0;
	public int j = 0;
	
	public static int n = 0;
	
	public static void main(String[] args)
	{
		//j = 0; // Compile time error Cannot make a static reference to the non-static field i
	}
	
	public static int getI()
	{
		//return i; // Compile time error : Cannot make a static reference to the non-static field i
		return n;
	}
	

}
