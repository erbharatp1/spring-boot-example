package com.bharat.reactive.programming.controller;

import java.time.Duration;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.bharat.reactive.programming.entity.Customer;
import com.bharat.reactive.programming.service.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
	private final CustomerService customerService;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Customer> createCustomer(@RequestBody Customer customer) {
		log.info("CustomerController.createCustomer()");
		return customerService.createCustomer(customer);
	}

	@GetMapping("/")
	public Flux<Customer> getCustomers() {
		log.info("CustomerController.getCustomers()");
		return customerService.getCustomers();

	}

	@GetMapping("/customer")
	public Mono<Customer> getCustomer(Long id) {
		log.info("CustomerController.getCustomer()");
		return customerService.getCustomer(id);
	}

	@PutMapping("/")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Mono<Customer> updateCustomer(@RequestBody Customer customer) {
		log.info("CustomerController.updateCustomer()");
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/")
	public Mono<Customer> delete(Long id) {
		log.info("CustomerController.delete()");
		return this.customerService.delete(id);
	}
	
//	private static RestTemplate restTemplate = new RestTemplate();
//
//    static {
//    	//http://127.0.0.1:8080/customer?id=3
//        String baseUrl = "http://localhost:8080";
//        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
//    }
//
//    public static void main(String[] args) {
//        Instant start = Instant.now();
//
//        for (int i = 1; i <= 5; i++) {
//            restTemplate.getForObject("/customer?id={id}", Customer.class, i);
//        }
//
//        logTime(start);
//    }
//
//    private static void logTime(Instant start) {
//        log.debug("Elapsed time: " + Duration.between(start, Instant.now()).toMillis() + "ms");
//    }
}
