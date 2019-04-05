package basictest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIteratorClassExample {
	

	
	public void HashMapTest()
	{
		HashMap<Integer, String> map = new  HashMap<Integer, String>();
		
		map.put(1, "vasu");
		map.put(2, "srinivas");
		map.put(3, "gouru");
		map.put(4,"reddy");
		
		Set<Integer> ketSet = map.keySet();
		
		Iterator i = ketSet.iterator();
		
		while(i.hasNext())
		{
			System.out.println(map.get(i.next()));
		}
		
		// By using Entry
		for(Map.Entry<Integer, String> entry : map.entrySet())
		{
			System.out.println(entry.getKey() + " : " +  entry.getValue());
		}
		
	}
	
	
	
	public static void main(String [] args)
	{
		MapIteratorClassExample hw = new MapIteratorClassExample();
		
		hw.HashMapTest();
	}
	

}
