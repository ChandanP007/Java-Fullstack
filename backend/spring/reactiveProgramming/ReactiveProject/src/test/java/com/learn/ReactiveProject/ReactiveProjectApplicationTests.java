package com.learn.ReactiveProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void workingWithMono() {

//		 Mono<String> errMono = Mono.error(new RuntimeException("Error !"));
//		
//		//created mono
//		Mono<String> m1 = Mono
//				.just("Learning reactive programming")
//				.log()
//				.then(errMono);
//		
//	  
//				
//		//consume the mono by subscribing
//		m1.subscribe((data)-> System.out.println(data));
//		
//		errMono.subscribe();

		Mono<String> m1 = Mono.just("Hi my name is rahul");
		Mono<String> m2 = Mono.just("Welcome to mono");
		Mono<Integer> m3 = Mono.just(123213);

		Mono<Tuple2<String, String>> comb = Mono.zip(m1, m2);
		Mono<Tuple2<String,String>> comb2 = m1.zipWith(m2);

		comb.subscribe(data -> {
			System.out.println(data.getT1());
			System.out.println(data.getT2());
		});
		
		Mono<String> result = m1.map(String::toUpperCase);
		result.subscribe(System.out::println);

		
	}
}
