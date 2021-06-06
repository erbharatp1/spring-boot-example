package com.bharat.reactive.programming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharat.reactive.programming.entity.Customer;
import com.bharat.reactive.programming.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Mono<Customer> createCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public Flux<Customer> getCustomers() {

		return customerRepository.findAll();
	}

	@Override
	public Mono<Customer> getCustomer(Long id) {

		return customerRepository.findById(id);
	}

	@Override
	public Mono<Customer> updateCustomer(Customer customer) {

		return this.customerRepository.findById(customer.getId()).map(c -> customer)
				.flatMap(this.customerRepository::save);
	}

	@Override
	public Mono<Customer> delete(Long id) {
		return this.customerRepository.findById(id)
				.flatMap(customer -> this.customerRepository.deleteById(customer.getId()).thenReturn(customer));
	}

}
