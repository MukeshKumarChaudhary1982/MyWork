package com.csc.integral.omni.client.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csc.integral.omni.client.entity.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
	
	 public List<Client> findByFirstNameIn(List<String> firstName);
	 public List<Client> findByFirstNameIgnoreCase(String firstName);
	 public List<Client> findByLastNameIgnoreCase(String lastName);
	 public List<Client> findByLastNameIn(List<String> lastName);
}
