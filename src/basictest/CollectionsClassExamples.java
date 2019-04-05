package basictest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class CollectionsClassExamples {
	
	
	public static void main(String[] args)
	{
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		
		List<Integer> syncList = Collections.synchronizedList(list);
		List<Integer> immutableList = Collections.unmodifiableList(list);
		
		//immutableList.add(200);// Runtime Exception :: java.lang.UnsupportedOperationException
		
		List<Integer> ls = Collections.singletonList(list.get(1));
		
		//ls.add(10); // Runtime Exception :: java.lang.UnsupportedOperationException
		
	}
	

}
