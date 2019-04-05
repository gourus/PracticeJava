package Java8Features;

@FunctionalInterface
interface Inf
{
	public int operation(int a, int b);
}


public class LambdaExpressions {

	
	private int operate(int a, int b, Inf i)
	{
		return i.operation(a, b);
	}
	
	
	public static void main(String [] args)
	{
		
		// Lambda Expression for Above functional Interface
		Inf add = (a,b)->a+b;
		Inf sub = (a,b)->a-b;
		
		LambdaExpressions le = new LambdaExpressions();
		
		System.out.println(le.operate(10, 20, add));
		System.out.println(le.operate(10, 20, sub));
		
		System.out.println(le.operate(80, 20, (a,b)->a+b));
		System.out.println(le.operate(30, 20, (a,b)->a-b));
		
		
		// Working Lambda Expressions with Runnable Interface
		Thread t = new Thread(()->System.out.println("Hello"));
		
		t.start();
	
	}
	
	
}
