package Java8Features;

import java.util.ArrayList;
import java.util.List;

public class StringJoinExample {
	
	
	public static void main(String[] args) {
		
		String str = String.join(", ", "Hello", "World", "Example");

		System.out.println(str);
		
		String str1 = String.join("/", "usr","local","bin");
		
		System.out.println(str1);
		
		List<String> list = new ArrayList<String>();
		
		list.add("one");list.add("two");list.add("three");
		
		System.out.println(String.join("--", list));
		
		
	}

}
