package basictest;

public class OverLoadExample {
	
	
	public void fun(String s)
	{
		System.out.println("String");
	}
	
	public void fun(StringBuffer s)
	{
		System.out.println("String Buffer");
	}
	
	public void num(Number n)
	{
		System.out.println("number");
	}
	
	public void num(Integer i)
	{
		System.out.println("integer");
	}
	
//	public void num(Double d)
//	{
//		System.out.println("Double");
//	}
	
	
	public static void main(String[] args) {
		
		OverLoadExample oe = new OverLoadExample();
		
		//oe.fun(null); error: reference to fun is ambiguous
		
		//oe.num(null); error: reference to fun is ambiguous
		
		oe.num(7);
		
		// Type conversion
		double a = 295.3;
		int b = 300;
		
		System.out.println((byte)a + " " + (byte)b );
		
		
	}

}
