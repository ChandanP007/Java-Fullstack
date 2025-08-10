package advJava;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ParallelStream {
	public static void main(String[] args) {
		int size = 10_000;
		List<Integer> nums = new ArrayList<>(size);
		
		Random ran = new Random();
		
		for(int i=0; i<size; i++) {
			nums.add(ran.nextInt(100));
		}
		
		int sum1 = nums.stream()
				.map(i -> i*2)
				.reduce(0,  (c,e)-> c+e);
		
		
		
		long startSeq = System.currentTimeMillis();
		int sum2 = nums.stream()
				.map(i -> {
					try {
						Thread.sleep(1);
					}catch(Exception e) {}
					return i*2;							
				})
				.mapToInt(i -> i)
				.sum();
		long endSeq = System.currentTimeMillis();
		
		long startSeq2 = System.currentTimeMillis();
		int sum3 = nums.parallelStream()
				.map(i -> {
					try {
						Thread.sleep(1);
					}catch(Exception e) {}
					return i*2;							
				})
				.mapToInt(i -> i)
				.sum();
		long endSeq2 = System.currentTimeMillis();
		
		System.out.println( sum2 + " " + sum3);
		System.out.println("Seq for Sum2 : " + (endSeq - startSeq));
		System.out.println("Seq for Sum3 : " + (endSeq2 - startSeq2));
	}
}
