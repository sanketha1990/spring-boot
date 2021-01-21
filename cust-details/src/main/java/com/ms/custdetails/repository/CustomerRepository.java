package com.ms.custdetails.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.custdetails.dto.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	//Customer findCustId(long id);
}
