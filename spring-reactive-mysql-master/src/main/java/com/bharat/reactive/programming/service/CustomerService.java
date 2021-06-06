package com.bharat.reactive.programming.service;

import com.bharat.reactive.programming.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CustomerService {

	public Mono<Customer> createCustomer(Customer customer);

	public Flux<Customer> getCustomers();

	public Mono<Customer> getCustomer(Long id);

	public Mono<Customer> updateCustomer(Customer customer);

	public Mono<Customer> delete(Long id);
}
