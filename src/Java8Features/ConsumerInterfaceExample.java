package Java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceExample implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {

		System.out.print(t+"\t");
	}
	
	
	public static void main(String arg[])
	{
		
		ConsumerInterfaceExample ci = new ConsumerInterfaceExample();
		
		List<Integer> li = new ArrayList<>();
		li.add(10);li.add(20);li.add(30);li.add(40);
		li.stream().forEach(ci);
		
		System.out.println();
		
		LambdaConsumer lc = new LambdaConsumer();
		lc.consumerTest();
		
		System.out.println();

	}
	
	

}

// Using lambda Expressions

class LambdaConsumer
{
	
	public void consumerTest()
	{
		Consumer<Integer> c = t -> System.out.println(t+"\t");
	
	
		List<Integer> li = new ArrayList<>();
	
		li.add(1);li.add(2);li.add(3);li.add(4);
		
		li.stream().forEach(c);
		
		
		
	}
	
	
}
