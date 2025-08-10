package com.learn.ReactiveProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.ReactiveProject.services.FluxLearnService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxLearnTest {

	@Autowired
	private FluxLearnService service;

	@Test
	public void simpleFluxTest() {

//		service.getFlux().subscribe(System.out::println);
//		service.fruitsFlux().subscribe(System.out::println);
//		service.mapExampleFlux().subscribe(System.out::println);

		Flux<String> capFlux = service.mapExampleFlux();

//		StepVerifier.create(capFlux).expectNextCount(2).verifyComplete();
		
		Flux<String> filtered = service.filterFlux();
		
//		StepVerifier.create(filtered).expectNextCount(1).verifyComplete();
		
		Flux<String> flatMapEx = service.getflatMap();
		flatMapEx.subscribe(System.out::println);
		
		
	}
	
	@Test
	public void transformTestExample() {
		Flux flux = service.transformExm();
		flux.subscribe(System.out::println);
		
	}
	
	@Test
	public void ifExample() {
		Flux<String> stringFlux = service.ifExample(8);
		StepVerifier.create(stringFlux).expectNextCount(1).verifyComplete();
	}

}
