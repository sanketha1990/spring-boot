package com.ms.custdetails.controller;

import java.util.List;

import com.ms.custdetails.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ms.custdetails.dto.Customer;
import com.ms.custdetails.service.CustomerService;

@RestController
@RequestMapping("/v1/customer")
public class CustomerDetailsController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/{custId}")
	public Customer getCustomer(@PathVariable("custId") long custId) {
		//return service.getCustomerById(custId);
		return new Customer();
	}
	
	@PostMapping
	public List<Customer> addCustomer(@RequestBody List<Customer> customer){
		return service.addCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getAllCustomer() {
		//return service.getCustomerById(custId);
		return service.getAllCustomer();
	}

	@DeleteMapping("/{custId}")
	public Response deleteCustomer(@PathVariable("custId") long custId){
	return service.deleteCustomer(custId);
	}

	@PutMapping
	public Response updateCustomer(@RequestBody Customer customer){
	return service.updateCustomer(customer);
	}

}
