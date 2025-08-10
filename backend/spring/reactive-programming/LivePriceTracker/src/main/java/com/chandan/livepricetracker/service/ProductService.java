package com.chandan.livepricetracker.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.chandan.livepricetracker.model.PriceEvent;
import com.chandan.livepricetracker.model.Product;
import com.chandan.livepricetracker.repo.ProductRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service		
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository repo;
	
	//A multicast sink that replays the latest to new subscribers if needed
	private final Sinks.Many<PriceEvent> sink = Sinks.many().multicast().onBackpressureBuffer();
	
	public Flux<Product> all(){
		return repo.findAll();
	}
	
	public Mono<Product> create(Product p){
		return repo.save(p)
				.doOnSuccess(prod -> {
					var event = new PriceEvent(prod.getId(), prod.getName(), prod.getPrice(), Instant.now());
					sink.tryEmitNext(event);
				});
	}
	
	public Mono<Product> updatePrice(String id, double newPrice){
		return repo.findById(id)
				.flatMap(p -> {
					p.setPrice(newPrice);
					return repo.save(p);
				})
				.doOnSuccess(prod-> {
					var event = new PriceEvent(prod.getId(), prod.getName(), prod.getPrice(), Instant.now());
					sink.tryEmitNext(event);
				});
	}
	
	public Flux<PriceEvent> priceEvents(){
		return sink.asFlux();
	}
}
