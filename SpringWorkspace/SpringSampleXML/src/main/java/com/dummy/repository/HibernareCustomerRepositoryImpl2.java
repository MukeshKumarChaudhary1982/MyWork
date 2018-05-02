package com.dummy.repository;

import java.util.ArrayList;
import java.util.List;

import com.dummy.model.Customer;

public class HibernareCustomerRepositoryImpl2 implements CustomerRepository {
	
	/* (non-Javadoc)
	 * @see com.dummy.repository.Customerrepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		
		List<Customer> customers=new ArrayList<>();
		
		Customer customer=new Customer();
		customer.setFirstname("Mukesh2");
		customer.setLastname("Chaudhary");
		
		customers.add(customer);
		
		return customers;
		
	}

}
