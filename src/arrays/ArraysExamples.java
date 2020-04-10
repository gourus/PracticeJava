package arrays;

import java.util.Arrays;

public class ArraysExamples {
	
	
	public enum Fix {
		
		A, B, C, D, E
	}
	
	public enum hello {
		He, SHE, HER, HIM;
		
		private final String hel;
		
		hello()
		{
			this.hel = "Hell";
		}
		
		public String getHel()
		{
			return this.hel;
		}
		
	}
	
	public static String getStr() {
		return "str";
	}
	
	public static void main(String[] args) {
		
		Boolean[] ar = new Boolean[5];
		
		System.out.println(hello.He.name());
		
		
		System.out.println(hello.He.getHel());
		
		switch("sdfs") {
		case "ad":
			System.out.println(getStr());
		break;
		default:
			System.out.println("nulll");
		}
		
		
		for (Boolean b : ar) {
			System.out.println(b);
		}
		
		Arrays.fill(ar, true);
		for (Boolean b : ar) {
			System.out.println(b);
		}
		
		for (int i=0; i< Fix.values().length; i++)
		{
			switch(i)
			{
			case 0:
				ar[Fix.A.ordinal()] = false;
				break;
			case 1:
				ar[Fix.B.ordinal()] = false;
				break;
			case 2:
				ar[Fix.C.ordinal()] = false;
				break;
			case 3:
				ar[Fix.D.ordinal()] = false;
				break;
			
			}
		}
		
		for (Boolean b : ar) {
			System.out.println(b);
		}
	
		Integer[] in = new Integer[] {1,2,3};
		
		
	}

}
