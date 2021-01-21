package com.ms.custdetails.service;

import java.util.List;

import com.ms.custdetails.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.custdetails.dto.Customer;
import com.ms.custdetails.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	/*
	 * public Customer getCustomerById(long custId) { return
	 * customerRepository.findCustId(custId); }
	 */
	
	public List<Customer> addCustomer(List<Customer> customer) {
		return (List<Customer>) customerRepository.saveAll(customer);
	}
	
	public List<Customer> getAllCustomer(){
		return (List<Customer>) customerRepository.findAll();
	}

	public Response deleteCustomer(long custId){
		Response response=new Response();
		boolean isIdExist=customerRepository.existsById(custId);
		if(isIdExist){
			customerRepository.deleteById(custId);
		}else{
			response.setMessage("Customer Id not found");
		}
		response.setMessage("Success");
		return response;
	}

	public Response updateCustomer(Customer customer){
		boolean isPresent=customerRepository.existsById(customer.getCustId());
		Response response=new Response();
		Customer custResponse=null;
		if(isPresent){
			custResponse=customerRepository.save(customer);
			response.setMessage("Customer id found");
			response.setCustomer(custResponse);
		}else {
			response.setMessage("Customer id Not found");
		}
		return response;
	}
}
