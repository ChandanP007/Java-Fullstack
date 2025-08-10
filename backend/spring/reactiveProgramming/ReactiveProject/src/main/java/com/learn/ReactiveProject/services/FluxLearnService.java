package com.learn.ReactiveProject.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service 
public class FluxLearnService {
	
	public void fluxTestingService(){
		System.out.println("Flex testing service");
	}
	
	
	//creating a flux
	public Flux<String> getFlux(){
		return Flux
				.just("Chandan","Divyanshu")
				.log();
	}

	//from collection
	public Flux<String> fruitsFlux(){
		List<String> fruitNames = List.of("apple", "mango");
		return Flux.fromIterable(fruitNames);
	}
	
	//empty flux
	public Flux<String> getBlankFlux(){
		return Flux.empty();
	}
	
	//map operator
	public Flux<String> mapExampleFlux(){
		Flux<String> capFlux = getFlux().map(name->name.toUpperCase());
		return capFlux;
		
	}
	
	//filter operator
	public Flux<String> filterFlux(){
		return getFlux().filter(name->name.length()>4);
	}
	
	//flatmap
	public Flux<String> getflatMap(){
		return getFlux().flatMap(name-> Flux.just(name.split("")));
	}
	
	//transform
	public Flux transformExm() {
		Function<Flux<String>, Flux<String>> fun = (name) -> name.map(String::toUpperCase);
		return getFlux().transform(fun).log();
	}
	
	public Flux<String> ifExample(int length){
		return getFlux().filter(name-> name.length()> length).defaultIfEmpty("ASDAOFNOAEINFOEICN").log();
	}
	
}
