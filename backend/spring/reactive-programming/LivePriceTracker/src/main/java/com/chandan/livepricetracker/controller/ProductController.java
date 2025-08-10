package com.chandan.livepricetracker.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.livepricetracker.model.PriceEvent;
import com.chandan.livepricetracker.model.Product;
import com.chandan.livepricetracker.service.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService service;
	
	@GetMapping
	public Flux<Product> all(){
		return service.all();
	}
	
	@PostMapping
	public Mono<Product> create(@RequestBody Product p){
		return service.create(p);
	}
	
	@PutMapping("/{id}/price")
	public Mono<Product> updatePrice(@PathVariable String id, @RequestParam double price){
		return service.updatePrice(id, price);
	}
	
//	SSE Endpoint for live price tracking
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<PriceEvent> events(){
		return service.priceEvents();
	}
}
