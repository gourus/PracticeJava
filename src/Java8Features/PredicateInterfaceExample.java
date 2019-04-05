package Java8Features;

import java.util.function.Predicate;

public class PredicateInterfaceExample {
	
	
	public static void main(String args[])
	{
		
		Predicate<Integer> predicate = (t) -> t%2 == 0;
		
	}
	
}


class PredicateInterface implements Predicate<Integer>
{

	@Override
	public boolean test(Integer t) {
		return t%2 == 0;
	}
	
}