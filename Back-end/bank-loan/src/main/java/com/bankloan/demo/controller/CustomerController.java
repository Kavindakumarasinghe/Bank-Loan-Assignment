package com.bankloan.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankloan.demo.model.Customer;
import com.bankloan.demo.repository.CustomerRepository;
import com.bankloan.demo.exceptions.ResourceNotFoundException;


@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	//get customer by id rest api
	
	@GetMapping("/customer/{user_id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int user_id ) {
	
		Customer customer = customerRepository.findById(user_id)
				.orElseThrow(() ->new ResourceNotFoundException("Customer not exist with id:"+ user_id));
		
		return ResponseEntity.ok(customer);
		
	}
	
	//post customer rest api
	
	@PostMapping("/customer")
	public Customer createCustomer (@RequestBody Customer customer) {
		
		return customerRepository.save(customer);
	}
	
	//put customer rest api
	
	@PutMapping("/customer/{user_id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int user_id, @RequestBody Customer customerDetails){
		
		Customer customer = customerRepository.findById(user_id)
				.orElseThrow(() ->new ResourceNotFoundException("Customer not exist with id:"+ user_id));
		
		customer.setAddress(customerDetails.getAddress());
		customer.setName(customerDetails.getName());
		customer.setPhone(customerDetails.getPhone());
		
		Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
		
	}
	
	//delete customer rest api
	
	@DeleteMapping("/customer/{user_id}")
	public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable int user_id){
		
		Customer customer = customerRepository.findById(user_id)
				.orElseThrow(() ->new ResourceNotFoundException("Customer not exist with id:"+ user_id));
		
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
	
}
