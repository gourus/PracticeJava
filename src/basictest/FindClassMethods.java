package basictest;

import java.lang.reflect.Method;

public class FindClassMethods {
	
	
	public static void main(String[] args) {
		
		String s = new String();
		
		Class<? extends String> cls = s.getClass();
		
		Method m[] = cls.getDeclaredMethods();
		
		int i;
		
		for(i=0; i< m.length; i++)
		{
			System.out.println(m[i]);
		}
		
		System.out.println("Number of methods : "+i);
		
	}

}
