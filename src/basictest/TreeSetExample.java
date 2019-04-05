package basictest;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExample {
	
	
	public static void main(String [] args)
	{
	
		TreeSet<Vasu> treeSet = new TreeSet<Vasu>();
		
		treeSet.add(new Vasu());
		treeSet.add(new Vasu(1));
		treeSet.add(new Vasu(2));
		treeSet.add(new Vasu(3));
		treeSet.add(new Vasu(4));
		treeSet.add(new Vasu(5));
		
		for(Vasu v : treeSet)
		{
			System.out.println(v.getI());
		}
		
		
		// Using Comparator
		TreeSet<Srinu> srinuSet = new TreeSet<Srinu>(new VasuComparator());
		
		srinuSet.add(new Srinu());
		srinuSet.add(new Srinu(1));
		srinuSet.add(new Srinu(2));
		srinuSet.add(new Srinu(3));
		srinuSet.add(new Srinu(4));
		srinuSet.add(new Srinu(5));
		
		for(Srinu s : srinuSet)
		{
			System.out.println(s.getI());
		}
		
	
	}
	
	

}

// Using comparator
class VasuComparator implements Comparator
{
	
	@Override
	public int compare(Object o1, Object o2) {
		Srinu s1 = (Srinu) o1;
		Srinu s2 = (Srinu) o2;
		
		return s1.getI() - s2.getI();
		
	}
}


class Srinu
{
	public int i;
	
	public Srinu()
	{
		// Constructor Chaining
		this(100);
	}

	public Srinu(int j) {
		i = j;
	}
	
	public int getI()
	{
		return i;
	}

	
}


// Using Comparable
class Vasu implements Comparable<Vasu>
{
	public int i;
	
	public Vasu()
	{
		// Constructor Chaining
		this(100);
	}

	public Vasu(int j) {
		i = j;
	}
	
	public int getI()
	{
		return i;
	}

	@Override
	public int compareTo(Vasu o) {
		//return o.getI() - this.getI(); // Descending order
		return this.getI() - o.getI();
	}
	
}