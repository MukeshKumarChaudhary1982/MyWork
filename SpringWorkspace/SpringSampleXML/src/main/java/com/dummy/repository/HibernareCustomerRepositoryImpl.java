package com.dummy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.dummy.model.Customer;

public class HibernareCustomerRepositoryImpl implements CustomerRepository {
	
	@Value("${dbUsername}")
	private String dbUsername;
	/*public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}*/
	/* (non-Javadoc)
	 * @see com.dummy.repository.Customerrepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		System.out.println("dbUsername"+dbUsername);
		List<Customer> customers=new ArrayList<>();
		
		Customer customer=new Customer();
		customer.setFirstname("Mukesh");
		customer.setLastname("Chaudhary");
		
		customers.add(customer);
		
		return customers;
		
	}

}
