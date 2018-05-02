package com.dummy.service;

import java.util.List;

import com.dummy.model.Customer;
import com.dummy.repository.CustomerRepository;
import com.dummy.repository.HibernareCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository=new HibernareCustomerRepositoryImpl();
	
	/* (non-Javadoc)
	 * @see com.dummy.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		
		return customerRepository.findAll();
	}

}
