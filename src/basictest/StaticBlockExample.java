package basictest;

import java.util.HashSet;
import java.util.Set;

public class StaticBlockExample {
	
	enum hello {
		HELLO("hello"),
		HOW_R_U("how_r_u"),
		IO("io");
		
		public final String hel;
		
		hello (String h) {
			hel = h;
		}
		
	};
	

	
	
	public static void main(String[] args) {
			
		Test t = new Test();
		
		Test.example(10);
		Test.example(20);
		
		hello h = hello.HELLO;
		
		System.out.println(h.toString());
		
	}

}

class Test {
	
	static Set<Integer> hSet = new HashSet<>();
	
	{
		System.out.println("instant block");
	}
	
	static void example(int ii) {
			
		System.out.println("Function called..");
		
		
	}	
}
