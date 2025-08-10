package com.chandan.livepricetracker.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.chandan.livepricetracker.model.Product;

import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
	Flux<Product> findByNameContainingIgnoreCase(String name);
	
}
