package com.dummy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dummy.model.Customer;


@Repository("customerRepository")
public class HibernareCustomerRepositoryImpl implements CustomerRepository {
	
	/* (non-Javadoc)
	 * @see com.dummy.repository.Customerrepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		
		List<Customer> customers=new ArrayList<>();
		
		Customer customer=new Customer();
		customer.setFirstname("Mukesh");
		customer.setLastname("Chaudhary");
		
		customers.add(customer);
		
		return customers;
		
	}

}
