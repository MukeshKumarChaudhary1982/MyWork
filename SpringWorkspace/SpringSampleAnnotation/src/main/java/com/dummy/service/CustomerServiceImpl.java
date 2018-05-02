package com.dummy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.model.Customer;
import com.dummy.repository.CustomerRepository;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	//@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We are in constructor injection");
		this.customerRepository = customerRepository;
	}

/*	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using setter injecion");
		this.customerRepository = customerRepository;
	}
*/
	/* (non-Javadoc)
	 * @see com.dummy.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		
		return customerRepository.findAll();
	}

}
