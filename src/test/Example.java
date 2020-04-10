package test;

// java add.class "10" 20

public class Example {
	
	 int a =10;
	 int A = 30;
	 int b = 20;
	 
	 
	 public Example () {
		 this (10, 20);
	 }
	 
	public Example (int a, int b) {
	
	}

	public static void main (String [] args) {
		//int a = Integer.valueOf(args[1]);
		//System.out.println(add(a,b));
		
		Example exam = new Example();		
		return;
	}
	
	public static int add(int a, int b) {
		int local = 1;
		return a + b;
	}
	
	public int max (int a, int b, int c)
	{
		int result = 0;
		
		{
			int l = 20;
		}
		
		
		// a 
		// b
		// a greater than b ; return a
		// b greater than a ; return b
		
		
		if (a > b) {
			// Execute if true
			result = a;
			if (a > c) {
				
			}
		}
		else if (true) {
			
		}
		else if (true) {
			
		}
		else {
			// Execute if false
			
			result = b;
			
		}
		
		switch (1) {
		case 1:
			
			break;
		case 2:
			break;
		default:
		}
		
	/*	loop (condition)
		{
		
		//Statement 1
		//Statement 2
		//Statement 3
			
			
		}
*/		
		
		//For
		//While
		//Do while
		
		// For ( expr 1; Condition ; expr 2 )
		
		
		
		for ( int loop = 0; loop < 10;    loop += 1    ) {
			System.out.println(loop);
			
		}
		
		int loop = 0 ;
		
		while (loop < 10) {
			
			loop += 1;
			
		}
		
		do {
			//Something
			
		} while (false);
		
		return result;
		
	}
	
}
