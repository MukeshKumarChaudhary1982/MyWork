package com.dummy.repository;

import java.util.List;

import com.dummy.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}