package com.csc.integral.omni.client.service;

import java.util.List;

import com.csc.integral.omni.client.entity.Client;

public interface ClientService {
	
	public List<Client> findAll();
	
	public Client findById(String theId);
	
	public void save(Client theClient);
	
	public void deletebyId(String theId);
	
	public List<Client> findByFirstName(List<String> firstName);
	
	public List<Client> findBylastName(List<String> lastName);
}
