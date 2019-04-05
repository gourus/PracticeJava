package Java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierInterfaceExample implements Supplier<Integer> {

	@Override
	public Integer get() {
		return null;
	}
	
	public static void main(String args[])
	{
		
		SupplierInterfaceExample si = new SupplierInterfaceExample();
		
		// Direct Example
		Supplier <Double> sd = ()-> Math.random();
		
		System.out.println(sd.get());
		
		
		List<Integer> li = new ArrayList<>();
		li.add(10);li.add(25);li.add(30);li.add(40);
		li.stream().filter(t->t%2==0).forEach(t->{System.out.println(t);});		
		
	}

}
