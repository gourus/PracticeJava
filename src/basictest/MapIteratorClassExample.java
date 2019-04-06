package basictest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class MapIteratorClassExample {
	

	
	public void HashMapTest()
	{
		HashMap<Integer, String> map = new  HashMap<Integer, String>();
		
		map.put(1, "vasu");
		map.put(2, "srinivas");
		map.put(3, "gouru");
		map.put(4,"reddy");
		
		System.out.println("Iterate Using KeySet : ");
		Set<Integer> ketSet = map.keySet();
		Iterator i = ketSet.iterator();
		while(i.hasNext())
		{
			Integer ii = (Integer) i.next();
			System.out.println(ii + " : " + map.get(ii));
		}
		
		System.out.println();
		
		System.out.println("Iterate Using Map.Entry :");
		// By using Entry
		for(Map.Entry<Integer, String> entry : map.entrySet())
		{
			System.out.println(entry.getKey() + " : " +  entry.getValue());
		}
		
		System.out.println();
		System.out.println("Iterate using Consumer Interface : ");
		// Iterate using Consumer interface	
		Consumer<Map.Entry<Integer, String>> action = System.out::println;
		map.entrySet().forEach(action);
		
		
	}
	
	
	
	public static void main(String [] args)
	{
		MapIteratorClassExample hw = new MapIteratorClassExample();
		
		hw.HashMapTest();
	}
	

}
