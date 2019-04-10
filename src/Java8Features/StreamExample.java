package Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 
 * An intermediate operation is called short circuiting, if it may produce finite stream for an infinite stream. 
 * For example limit() and skip() are two short circuiting intermediate operations.
 * 
 * 
 * A terminal operation is called short circuiting, if it may terminate in finite time for infinite stream. 
 * For example anyMatch, allMatch, noneMatch, findFirst and findAny are short circuiting terminal operations.
 * 
 */

public class StreamExample {
	
	public static void main(String a[])
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.add(20);al.add(30);al.add(95);
		al.add(37);al.add(45);al.add(66);
		
		System.out.println(al.stream().allMatch(i->i>35)); // false
		
		List<Integer> l = al.stream().filter(i->i%2==0).collect(Collectors.toList());
		
		System.out.println(l);
	
		al.stream().map(i->i+20).forEach(System.out::print);
		
		System.out.println();
		
		al.stream().forEach(i->{
			System.out.print(i*i);
			System.out.print('\t');
		});
		
		System.out.println();
		
		System.out.println("count of Filtered Elements : " + al.stream().filter(i->i>=35).count());
		
		al.stream().filter(i->i>=20).forEach(i->{
			double ii = Math.pow(i, i);
			System.out.print(ii);
			System.out.print('\t');
		});
		
		System.out.println();
		
		al.stream()
		.filter(i->i>=20)
		.map(i->i-10)
		.forEach(i->{
			double ii = Math.pow(i, i);
			System.out.print(ii);
			System.out.print('\t');
		});
		
		System.out.println();
		
		Integer iArr[] = {1,2,3,4,5,6,7};
		
		// Converting Array to Stream
		System.out.println("Sum() of array values which are greater than or equal to 5 : " + Stream.of(iArr).filter(i->i>=5).mapToInt(i->i).sum());
		
		Stream<String> stream1 = Stream.generate(() -> {return "abc";});
		Stream<String> stream2 = Stream.iterate("abc", (i) -> i);
		
		//System.out.println("count : " +stream1.count());
		
		
		Stream<Integer> intStream = Stream.of(1,2,3,4); //stream is closed, so we need to create it again
		Map<Object, Object> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i+10));
		System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}
		
		
		
		Stream<Integer> intStreamArr = Stream.of(1,2,3,4);
		Integer[] intArray = intStreamArr.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray)); //prints [1, 2, 3, 4]
		
		
		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println(names.map(s -> {
				return s.toUpperCase();
			}).collect(Collectors.toList()));
		
		Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
		List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted); // [ef, d, aBc, 123456]

		Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
		List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
		System.out.println(naturalSorted); //[123456, aBc, d, ef]
		
		
		Stream<List<String>> namesOriginalList = Stream.of(
				Arrays.asList("vasu"), 
				Arrays.asList("srinu", "gouru"),
				Arrays.asList("Reddy"));
			//flat the stream from List<String> to String stream
			Stream<String> flatStream = namesOriginalList
				.flatMap(strList -> strList.stream());

			flatStream.forEach(System.out::println);
			
			Stream<Integer> numbers = Stream.of(1,2,3,4,5);
			
			Optional<Integer> intOptional = numbers.reduce((i,j) -> {return i*j;});
			if(intOptional.isPresent()) System.out.println("Multiplication = "+intOptional.get()); //120
		
		
	}

}
