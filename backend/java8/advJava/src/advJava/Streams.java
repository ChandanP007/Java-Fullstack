package advJava;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class Streams {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(4,3,2,1,3);
		List<Integer> nums2 = Arrays.asList(4,5,7,3,2,6);
		
		Consumer<Integer> con = n -> System.out.print(n);
	
//		nums.forEach(con);
		
		Predicate<Integer> p = new Predicate<Integer>() {
			public boolean test(Integer n) {
				if(n%2 == 0) return true;
				else return false;
			}
		};
		
		//or 
		Predicate<Integer> pl = n -> n%2==0;
		
		Function<Integer,Integer> fun = new Function<>
		() {
			public Integer apply(Integer n) {
				return n*2;
			}
		};
		
		//or
		
		Function<Integer,Integer> fun2 = n -> n*2;
		
		int result = nums.stream()
				.filter(p)
				.map(fun)
				.reduce(0, (c,e)-> c+e);
		
		System.out.println("Result : "+result);
		
		
		//Parallel stream works well with filtering but not sorted cuz sorting needs all the elements together
		Stream<Integer> sortedValues = nums2.stream()
				.filter(n -> n%2 == 0)
				.sorted();
	
		sortedValues.forEach(n-> System.out.println(n));
		
	}
}
